package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.Card;

import java.util.List;

public interface CardService {
    Card save(Card card);

    Card findById(Long id);

    void delete(Card card);

    List<Card> findAll();

    Card saveAndFlush(Card card);

}
