package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CarRepository;
import it.academy.booking.tourist.request.Car;
import it.academy.booking.tourist.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    public Car save(Car car){
        return carRepository.save(car);
    }

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }

    public void delete(Car car){
        carRepository.delete(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car saveAndFlush(Car car){
        return carRepository.saveAndFlush(car);
    }
}
