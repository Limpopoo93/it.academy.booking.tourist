package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Car;
import it.academy.booking.tourist.request.CheckCar;
import it.academy.booking.tourist.request.Company;
import it.academy.booking.tourist.service.impl.CarServiceImpl;
import it.academy.booking.tourist.service.impl.CheckCarServiceImpl;
import it.academy.booking.tourist.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarServiceImpl carService;
    @Autowired
    private CheckCarServiceImpl checkCarService;
    @Autowired
    private CompanyServiceImpl companyService;

    //список машин для конкретной компании которые не удалены
    @GetMapping("/listAllCar")
    public String findByAllCar(Model model) {
        //придумать как брать id компании
        Long id = 3L;
        List<Car> cars = carService.findByDeleteAndCompanyId(true, id);
        model.addAttribute("cars", cars);
        return "listAllCar";
    }

    //удаление машины
    @GetMapping("/carDeleteId/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        Car car = carService.findById(id);
        CheckCar checkCar = checkCarService.findByCarId(id);
        if (checkCar != null) {
            //это проверка занята ли машине если да то нельзя удалить
            return "index";
        }

        car.setDelete(false);
        carService.saveAndFlush(car);
        return "index";
    }

    //сохранение машины
    @GetMapping("/carRegistration")
    public String saveCar(Car car) {
        return "saveCar";
    }

    @PostMapping("/carRegistration")
    public String saveCountry(@Valid Car car, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "saveCar";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        car.setDelete(true);
        Company company = (Company) companyService.findByAuthenticateId(authenticate.getId());
        car.setCompany(company);
        carService.save(car);
        return "index";
    }
}
