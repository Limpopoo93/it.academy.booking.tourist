package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Car;
import it.academy.booking.tourist.request.Company;
import it.academy.booking.tourist.request.Country;
import it.academy.booking.tourist.request.Town;
import it.academy.booking.tourist.service.impl.CarServiceImpl;
import it.academy.booking.tourist.service.impl.CompanyServiceImpl;
import it.academy.booking.tourist.service.impl.CountryServiceImpl;
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
public class CountryController {
    @Autowired
    private CountryServiceImpl countryService;
    @Autowired
    private TownServiceImpl townService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private CarServiceImpl carService;

    //список всех городов которые не удалены
    @GetMapping("/listAllCountry")
    public String findByAllTown(Model model) {
        List<Country> countries = countryService.findByDelete(true);
        model.addAttribute("countries", countries);
        return "listAllCountry";
    }

    //сохранение страны
    @GetMapping("/countryRegistration")
    public String saveCountry(Country country) {
        return "saveCountry";
    }

    @PostMapping("/countryRegistration")
    public String saveCountry(@Valid Country country, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "saveCountry";
        }
        country.setDelete(true);
        countryService.save(country);
        return "index";
    }

    //удаление страны
    @GetMapping("/countryDeleteId/{id}")
    public String deleteTown(@PathVariable("id") Long id) {
        Country country = countryService.findById(id);
        country.setDelete(false);
        List<Town> towns = townService.findByCountryId(country.getId());
        for (Town town : towns) {
            town.setDelete(false);
            townService.saveAndFlush(town);
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
        }
        countryService.saveAndFlush(country);
        return "index";
    }
}
