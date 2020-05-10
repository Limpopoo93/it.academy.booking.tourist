package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Town;

import java.util.List;

public interface TownService {
    Town save(Town town);

    Town findById(Long id);

    void delete(Town town);

    List<Town> findAll();

    Town saveAndFlush(Town town);

    List<Town> findByDelete(Boolean delete);

    List<Town> findByNameTown(String town);

    List<Town> findByCountryId(Long id);
}
