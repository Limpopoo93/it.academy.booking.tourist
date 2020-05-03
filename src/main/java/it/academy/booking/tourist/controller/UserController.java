package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.repository.AuthenticateRepository;
import it.academy.booking.tourist.request.Authenticate;
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
    private AuthenticateRepository authenticateRepository;
    //для старта
    @GetMapping("/")
    public String hello(Model model) {
        return "main";
    }
    //переход с главной на страницу входа
    @GetMapping("/userComeIn")
    public String comeInUser(Authenticate authenticate) {
        return "";
    }
    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/userComeIn")
    public String comeInUserByForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticateResult = authenticateRepository.findByLogin(authenticate.getLogin());
        if(authenticateResult != null){
            if(authenticate.getLogin().equals(authenticateResult.getLogin()) && authenticate.getPassport().equals(authenticateResult.getPassport()) && authenticateResult.getDelete().equals(true)){
                if(authenticateResult.getActive().equals(true)){
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
}
