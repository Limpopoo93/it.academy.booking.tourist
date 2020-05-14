package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.*;
import it.academy.booking.tourist.service.impl.AuthenticateServiceImpl;
import it.academy.booking.tourist.service.impl.CarServiceImpl;
import it.academy.booking.tourist.service.impl.CheckCarServiceImpl;
import it.academy.booking.tourist.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CheckAutoController {
    @Autowired
    private CheckCarServiceImpl checkCarService;
    @Autowired
    private AuthenticateServiceImpl authenticateService;
    @Autowired
    private CarServiceImpl carService;
    @Autowired
    private PriceServiceImpl priceService;

    //список забронированных машин для юзера
    @GetMapping("/listAllCheckCar")
    public String findByAllCheckCar(Model model, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        List<CheckCar> checkCars = checkCarService.findByAuthenticateId(authenticate.getId());
        model.addAttribute("checkCars", checkCars);
        return "listAllCheckCar";
    }
    //список забронированных машин по конкретному юзеру для админа
    @GetMapping("/listAllCheckCarAdmin")
    public String findByAllCheckCarAdmin(Model model, HttpSession session, Authenticate authenticate) {
        Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
        if(authenticateResult != null){
            List<CheckCar> checkCars = checkCarService.findByAuthenticateId(authenticate.getId());
            model.addAttribute("checkCars", checkCars);
            return "listAllCheckCar";
        }
        return "index";
    }
    // 1 этап бронирования автомобиля. Где параметры две даты город и страна и вывод всех машин
    @PostMapping("/searchFormCountry")
    public String searchCar(CarSearch carSearch, HttpSession session, Model model) {
        List<Car> cars = carService.findByCompanyTownNameTownAndCompanyTownCountryNameCountry(carSearch.getTown(), carSearch.getCountry());
        session.setAttribute("carSearch", carSearch);
        model.addAttribute("cars", cars);
        return "carBookUser";
    }
    // 2 этап бронирования автомобиля. Когда идет проверка не занят ли он.
    @PostMapping("/bookCarId/{id}")
    public String carByBook(@PathVariable("id") Long id, HttpSession session, Model model, CarSearch carSearch) {
        Car carResult = carService.findById(id);
        CarSearch carSearchResult = (CarSearch) session.getAttribute("carSearch");
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        List<CheckCar> checkCars = checkCarService.findByBusyDate(carSearchResult.getDateCheck(), carSearchResult.getDateReturn());
        if (checkCars.isEmpty()) {
            CheckCar checkCar = new CheckCar();
            checkCar.setDateCheck(carSearchResult.getDateCheck());
            checkCar.setDateReturn(carSearchResult.getDateReturn());
            checkCar.setAuthenticate(authenticate);
            checkCar.setCar(carResult);
            checkCar.setDelete(true);
            Long colDay = daysBetween(carSearchResult.getDateCheck(), carSearchResult.getDateReturn());
            Price price = priceService.findByCarId(carResult.getId());
            Long finalPrice = price.getPrice() * colDay;
            checkCar.setPrice(finalPrice);
            checkCarService.save(checkCar);
            return "index";
        }
        //дата занята бронирование не возможно
        return "index";
    }
    public Long daysBetween(Date d1, Date d2) {
        if(d1.equals(d2)){
            return 1L;
        }
        return ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
