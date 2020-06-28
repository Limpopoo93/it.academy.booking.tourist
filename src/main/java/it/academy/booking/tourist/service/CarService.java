package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);

    Car findById(Long id);

    void delete(Car car);

    List<Car> findAll();

    Car saveAndFlush(Car car);

    List<Car> findByAllCar(String town, String country);
}
