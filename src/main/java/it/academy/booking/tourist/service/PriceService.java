package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Price;

import java.util.List;

public interface PriceService {
    Price save(Price price);

    Price findById(Long id);

    void delete(Price price);

    List<Price> findAll();

    Price saveAndFlush(Price price);
}
