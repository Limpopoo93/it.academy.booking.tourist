package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.service.impl.AuthenticateServiceImpl;
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
public class AdminController {
    @Autowired
    private AuthenticateServiceImpl authenticateService;

    //регистрация с главной страницы для обычного пользователя
    @GetMapping("/adminRegistration")
    public String adminRegistration(Authenticate authenticate) {
        return "adminRegistration";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/adminRegistration")
    public String adminRegistrationForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Model model) {
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

    //список всех юзеров которые не удалены ( в зависимости от приходящей роли )
    @GetMapping("/listAllUser")
    public String findByAllUser(Model model) {
        List<Authenticate> authenticates = authenticateService.findByDeleteAndRoles(true, String.valueOf(model.getAttribute("role")));
        model.addAttribute("authenticates", authenticates);
        return "listAllUser";
    }

    //список заблакированных пользователей
    @GetMapping("/listAllBlockUser")
    public String findByAllBlockUser(Model model) {
        List<Authenticate> authenticates = authenticateService.findByAcess(false);
        model.addAttribute("authenticates", authenticates);
        return "listAllBlockUser";
    }

    //блокировка юзера
    @GetMapping("/userBlock/{id}")
    public String userBlockList(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setAcess(false);
        authenticateService.saveAndFlush(authenticate);
        return "index";
    }

    //разблокировка юзера
    @GetMapping("/userUnBlockLetterId/{id}")
    public String unblockUserByListLetter(@PathVariable("id") Long id) {
        Authenticate authenticate = authenticateService.findById(id);
        authenticate.setAcess(true);
        authenticateService.saveAndFlush(authenticate);
        return "index";
    }

    //поиск пользователя по логину ( для админа )
    @GetMapping("/searchUserByLogin")
    public String searchUserByLogin(Authenticate authenticate) {
        return "searchUserByLogin";
    }

    @PostMapping("/searchUserByLogin")
    public String searchUserByLoginForm(@Valid Authenticate authenticate, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticateResult = authenticateService.findByLogin(authenticate.getLogin());
        if (authenticateResult == null) {
            return "index";
        }
        model.addAttribute("authenticate", authenticateResult);
        return "searchUserByLoginForm";
    }
}
