package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.repository.AuthenticateRepository;
import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Role;
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
public class UserController {
    @Autowired
    private AuthenticateServiceImpl authenticateService;

    //для старта
    @GetMapping("/")
    public String hello(Model model) {
        return "main";
    }

    //переход с главной на страницу входа
    @GetMapping("/userComeIn")
    public String comeInUser(Authenticate authenticate) {
        return "comeIn";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/userComeIn")
    public String comeInUserByForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
        if (authenticateResult != null) {
            if (authenticate.getLogin().equals(authenticateResult.getLogin()) && authenticate.getPassword().equals(authenticateResult.getPassword()) && authenticateResult.getDelete().equals(true)) {
                if (authenticateResult.getActive().equals(true)) {
                    //доступ разрешен
                    session.setAttribute("authenticate", authenticateResult);
                    return "index";
                }
                // пользователь забанен
                session.setAttribute("authenticate", authenticateResult);
                return "letterAdmin";
            }
            //не верный логин и пароль или пользователь удален
            return "main";
        }
        //юзер отсутствует
        return "main";
    }

    //регистрация с главной страницы для обычного пользователя
    @GetMapping("/userRegistration")
    public String userRegistration(Authenticate authenticate) {
        return "userRegistration";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/userRegistration")
    public String userRegistrationForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
        if (authenticateResult == null) {
            if (authenticate.getLogin().equals(authenticateResult.getLogin()) && authenticate.getPassword().equals(authenticateResult.getPassword())) {
                return "userRegistration";
            }
            authenticate.setAcess(true);
            authenticate.setDelete(true);
            authenticate.setActive(true);
            // при регистрации сделать добавление роли в базу данных.
           // authenticate.setRoles();
            authenticateService.save(authenticate);
            session.setAttribute("authenticate", authenticate);
            return "index";
        }
        //юзер отсутствует
        return "main";
    }

}
