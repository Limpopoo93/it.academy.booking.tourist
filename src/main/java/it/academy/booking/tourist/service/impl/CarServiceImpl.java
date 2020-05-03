package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CarRepository;
import it.academy.booking.tourist.request.Car;
import it.academy.booking.tourist.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
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
}
