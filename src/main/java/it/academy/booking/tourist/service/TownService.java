package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Town;

import java.util.List;
import java.util.Optional;

public interface TownService {
    Town save(Town town);

    Optional<Town> findById(Long id);

    void delete(Town town);

    List<Town> findAll();

    Town saveAndFlush(Town town);
}
