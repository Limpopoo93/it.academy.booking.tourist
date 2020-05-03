package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car save(Car car);

    Optional<Car> findById(Long id);

    void delete(Car car);

    List<Car> findAll();

    Car saveAndFlush(Car car);
}
