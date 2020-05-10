package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Car;
import it.academy.booking.tourist.request.Company;
import it.academy.booking.tourist.request.Town;
import it.academy.booking.tourist.service.impl.AuthenticateServiceImpl;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private AuthenticateServiceImpl authenticateService;
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private TownServiceImpl townService;
    @Autowired
    private CarServiceImpl carService;

    //регистрация с главной страницы для обычного пользователя
    @GetMapping("/companyUserRegistration")
    public String companyUserRegistration(Authenticate authenticate) {
        return "companyUserRegistration";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/companyUserRegistration")
    public String companyUserRegistrationForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
        if (authenticateResult == null) {
            if (authenticate.getLogin().equals(authenticateResult.getLogin()) && authenticate.getPassword().equals(authenticateResult.getPassword())) {
                return "index";
            }
            authenticate.setAcess(true);
            authenticate.setDelete(true);
            authenticate.setActive(true);
            // при регистрации сделать добавление роли в базу данных.
            // authenticate.setRoles();
            authenticateService.save(authenticate);
            return "index";
        }
        //юзер отсутствует
        return "main";
    }

    //список всех компаний которые не удалены
    @GetMapping("/listAllCompany")
    public String findByAllCompany(Model model) {
        List<Company> companies = companyService.findByDelete(true);
        model.addAttribute("companies", companies);
        return "listAllCompany";
    }

    //список всех городов которые не удалены
    @GetMapping("/listAllTown")
    public String findByAllTown(Model model) {
        List<Town> towns = townService.findByDelete(true);
        model.addAttribute("towns", towns);
        return "listAllTown";
    }

    //сохранение компании
    @GetMapping("/companyRegistration")
    public String saveCompany(Company company) {
        return "saveCompany";
    }

    @PostMapping("/companyRegistration")
    public String saveTown(@Valid Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "saveCompany";
        }
        Town town = (Town) townService.findByNameTown(company.getTown().getNameTown());
        if (town != null && town.getDelete().equals(true)) {
            company.setDelete(true);
            company.setReting(0);
            company.setTown(town);
            companyService.save(company);
            return "index";
        }
        return "saveCompany";
    }

    //удаление компании для админа
    @GetMapping("/companyDeleteId/{id}")
    public String deleteCompanyAdmin(@PathVariable("id") Long id) {
        Company company = companyService.findById(id);
        company.setDelete(false);
        List<Car> cars = carService.findByCompanyId(company.getId());
        for (Car car : cars) {
            car.setDelete(false);
            carService.saveAndFlush(car);
        }
        return "index";
    }

    //удаление компании для админа
    @PostMapping("/companyDelete")
    public String deleteCompany(@Valid Company company, BindingResult bindingResult, HttpSession session) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        List<Company> companies = companyService.findByAuthenticateId(authenticate.getId());
        for (Company companyResult : companies) {
            companyResult.setDelete(false);
            companyService.saveAndFlush(companyResult);
            List<Car> cars = carService.findByCompanyId(companyResult.getId());
            for (Car car : cars) {
                car.setDelete(false);
                carService.saveAndFlush(car);
            }
        }
        return "index";
    }

    //поиск компании по названию ( для админа )
    @GetMapping("/searchCompanyByName")
    public String searchCompanyByName(Company company) {
        return "searchCompanyByName";
    }

    @PostMapping("/searchCompanyByName")
    public String searchCompanyByNameForm(@Valid Company company, BindingResult bindingResult, HttpSession session, Model model) {
        Company companyReult = companyService.findByName(company.getName());
        if (companyReult == null) {
            return "index";
        }
        model.addAttribute("company", companyReult);
        return "searchCompanyByNameForm";
    }
}
