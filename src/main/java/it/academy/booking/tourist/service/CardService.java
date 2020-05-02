package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    Card save(Card card);
    Optional<Card> findById(Long id);
    void delete(Card card);
    List<Card> findAll();
    Card saveAndFlush(Card card);
}
