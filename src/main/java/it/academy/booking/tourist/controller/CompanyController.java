package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.service.impl.AuthenticateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CompanyController {
    @Autowired
    private AuthenticateServiceImpl authenticateService;
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
}
