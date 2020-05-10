package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.CheckCar;

import java.util.List;

public interface CheckCarService {
    CheckCar save(CheckCar checkCar);

    CheckCar findById(Long id);

    void delete(CheckCar checkCar);

    List<CheckCar> findAll();

    CheckCar saveAndFlush(CheckCar checkCar);

    List<CheckCar> findByAuthenticateId(Long id);

    CheckCar findByCarId(Long id);
}
