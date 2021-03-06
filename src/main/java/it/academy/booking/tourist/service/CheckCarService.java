package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.CheckCar;

import java.util.Date;
import java.util.List;

public interface CheckCarService {
    CheckCar save(CheckCar checkCar);

    CheckCar findById(Long id);

    void delete(CheckCar checkCar);

    List<CheckCar> findAll();

    CheckCar saveAndFlush(CheckCar checkCar);

    List<CheckCar> findByCheckCar(Date dateCheck, Date dateReturn, Long id);
}
