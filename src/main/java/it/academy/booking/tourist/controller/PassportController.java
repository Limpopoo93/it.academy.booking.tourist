package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Passport;
import it.academy.booking.tourist.service.impl.PassportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PassportController {
    @Autowired
    private PassportServiceImpl passportService;

    //регистрация банковской карточки для пользователя
    @GetMapping("/passportCreate")
    public String passportCreate(Passport passport) {
        return "passportCreate";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/passportCreate")
    public String passportCreateForm(@Valid Passport passport, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        Passport passportResult = passportService.findByAuthenticateId(authenticate.getId());
        if (passportResult == null) {
            passport.setAuthenticate(authenticate);
            passport.setDelete(true);
            passportService.save(passport);
            return "index";
        }
        return "index";
    }

    //удаление банковской карточки для пользоваля
    @GetMapping("/passportDelete")
    public String passportDelete(Passport passport) {
        return "passportDelete";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/passportDelete")
    public String passportDeleteForm(@Valid Passport passport, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        Passport passportResult = passportService.findByAuthenticateId(authenticate.getId());
        if (passportResult != null) {
            if (passport.getIndeficialPassport().equals(passportResult.getIndeficialPassport()) && passport.getNumberPassport().equals(passportResult.getNumberPassport())) {
                passportResult.setDelete(false);
                passportService.saveAndFlush(passportResult);
                return "index";
            }
        }
        return "index";
    }
}
