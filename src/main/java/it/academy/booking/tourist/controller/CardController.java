package it.academy.booking.tourist.controller;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Card;
import it.academy.booking.tourist.service.impl.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CardController {
    @Autowired
    private CardServiceImpl cardService;

    //регистрация банковской карточки для пользователя
    @GetMapping("/cardCreate")
    public String cardCreate(Card card) {
        return "cardCreate";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/cardCreate")
    public String cardCreateForm(@Valid Card card, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        Card cardResult = cardService.findByAuthenticateId(authenticate.getId());
        if (cardResult == null) {
            card.setAuthenticate(authenticate);
            cardService.save(card);
            return "index";
        }
        return "cardCreate";
    }

    //удаление банковской карточки для пользоваля
    @GetMapping("/cardDelete")
    public String cardDelete(Card card) {
        return "cardDelete";
    }

    //переход со страницы входа ( проверка ) и пуск на страницу index
    @PostMapping("/cardDelete")
    public String cardDeleteForm(@Valid Card card, BindingResult bindingResult, HttpSession session, Model model) {
        Authenticate authenticate = (Authenticate) session.getAttribute("authenticate");
        Card cardResult = cardService.findByKeyNumberAndUsd(card.getKeyNumber(), card.getUsd());
        if (cardResult != null && cardResult.getAuthenticate().getId().equals(authenticate.getId())) {
            cardResult.setDelete(false);
            cardService.saveAndFlush(cardResult);
            return "index";
        }
        //карточка не прошла проверку
        return "index";
    }
}
