package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Message;
import it.academy.booking.tourist.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageServiceImpl messageService;

    //список не удаленных писем
    @GetMapping("/listAllMessage")
    public String findByAllMessage(Model model) {
        List<Message> messages = messageService.findByDelete(true);
        model.addAttribute("messages", messages);
        return "listAllMessages";
    }

    //сохранение письма для админа
    @GetMapping("/letterRegistration")
    public String saveLetter(Message message) {
        return "saveMessage";
    }

    @PostMapping("/letterRegistration")
    public String saveLetter(@Valid Message message, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "saveMessage";
        }
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        Date date = new Date();
        message.setDateMessage(date);
        message.setAuthenticate(authenticate);
        messageService.save(message);
        return "main";
    }

    //удаление письма от юзера
    @GetMapping("/messageDeleteId/{id}")
    public String deleteMessage(@PathVariable("id") Long id) {
        Message message = messageService.findById(id);
        message.setDelete(false);
        messageService.saveAndFlush(message);
        return "index";
    }
}
