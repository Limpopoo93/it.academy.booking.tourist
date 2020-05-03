package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.CheckCar;

import java.util.List;
import java.util.Optional;

public interface CheckCarService {
    CheckCar save(CheckCar checkCar);

    Optional<CheckCar> findById(Long id);

    void delete(CheckCar checkCar);

    List<CheckCar> findAll();

    CheckCar saveAndFlush(CheckCar checkCar);
}
