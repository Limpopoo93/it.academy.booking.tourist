package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.model.Card;
import it.academy.booking.tourist.repository.CardRepository;
import it.academy.booking.tourist.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Card card) {
        cardRepository.delete(card);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    @Transactional
    public Card saveAndFlush(Card card) {
        return cardRepository.saveAndFlush(card);
    }

    @Override
    public Card findByAuthenticateId(Long id) {
        return cardRepository.findByAuthenticateId(id);
    }

}
