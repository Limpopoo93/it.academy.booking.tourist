package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);

    Country findById(Long id);

    void delete(Country country);

    List<Country> findAll();

    Country saveAndFlush(Country country);

}
