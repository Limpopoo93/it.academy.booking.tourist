package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CardRepository;
import it.academy.booking.tourist.request.Card;
import it.academy.booking.tourist.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card save(Card card){
        return cardRepository.save(card);
    }

    public Optional<Card> findById(Long id){
        return cardRepository.findById(id);
    }

    public void delete(Card card){
        cardRepository.delete(card);
    }

    public List<Card> findAll(){
        return cardRepository.findAll();
    }

    public Card saveAndFlush(Card card){
        return cardRepository.saveAndFlush(card);
    }
}
