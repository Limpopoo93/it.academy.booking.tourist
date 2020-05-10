package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Car;
import it.academy.booking.tourist.request.Company;
import it.academy.booking.tourist.request.Town;
import it.academy.booking.tourist.service.impl.CarServiceImpl;
import it.academy.booking.tourist.service.impl.CompanyServiceImpl;
import it.academy.booking.tourist.service.impl.TownServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TownController {
    @Autowired
    private TownServiceImpl townService;
    @Autowired
    private CarServiceImpl carService;
    @Autowired
    private CompanyServiceImpl companyService;

    //список всех городов которые не удалены
    @GetMapping("/listAllTown")
    public String findByAllTown(Model model) {
        List<Town> towns = townService.findByDelete(true);
        model.addAttribute("towns", towns);
        return "listAllTown";
    }

    //сохранение города
    @GetMapping("/townRegistration")
    public String saveCountry(Town town) {
        return "saveTown";
    }

    @PostMapping("/townRegistration")
    public String saveTown(@Valid Town town, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "saveTown";
        }
        town.setDelete(true);
        townService.save(town);
        return "index";
    }

    //удаление города
    @GetMapping("/townDeleteId/{id}")
    public String deleteTown(@PathVariable("id") Long id) {
        Town town = townService.findById(id);
        town.setDelete(false);
        List<Company> companies = companyService.findByTownId(town.getId());
        for (Company company : companies) {
            company.setDelete(false);
            companyService.saveAndFlush(company);
            List<Car> cars = carService.findByCompanyId(company.getId());
            for (Car car : cars) {
                car.setDelete(false);
                carService.saveAndFlush(car);
            }
        }
        townService.saveAndFlush(town);
        return "index";
    }
}
