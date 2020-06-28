package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.model.Car;
import it.academy.booking.tourist.repository.CarRepository;
import it.academy.booking.tourist.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    @Transactional
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    @Transactional
    public Car saveAndFlush(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public List<Car> findByAllCar(String town, String country) {
        return carRepository.findByAllCar(town, country);
    }

}
