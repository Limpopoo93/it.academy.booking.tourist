package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CheckCarRepository;
import it.academy.booking.tourist.request.CheckCar;
import it.academy.booking.tourist.service.CheckCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckCarServiceImpl implements CheckCarService {
    @Autowired
    private CheckCarRepository checkCarRepository;

    public CheckCar save(CheckCar checkCar){
        return checkCarRepository.save(checkCar);
    }

    public Optional<CheckCar> findById(Long id){
        return checkCarRepository.findById(id);
    }

    public void delete(CheckCar checkCar){
        checkCarRepository.delete(checkCar);
    }

    public List<CheckCar> findAll(){
        return checkCarRepository.findAll();
    }

    public CheckCar saveAndFlush(CheckCar checkCar){
        return checkCarRepository.saveAndFlush(checkCar);
    }
}
