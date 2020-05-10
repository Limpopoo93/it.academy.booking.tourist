package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CheckCarRepository;
import it.academy.booking.tourist.request.CheckCar;
import it.academy.booking.tourist.service.CheckCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CheckCarServiceImpl implements CheckCarService {
    @Autowired
    private CheckCarRepository checkCarRepository;

    @Override
    @Transactional
    public CheckCar save(CheckCar checkCar) {
        return checkCarRepository.save(checkCar);
    }

    @Override
    public CheckCar findById(Long id) {
        return checkCarRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(CheckCar checkCar) {
        checkCarRepository.delete(checkCar);
    }

    @Override
    public List<CheckCar> findAll() {
        return checkCarRepository.findAll();
    }

    @Override
    @Transactional
    public CheckCar saveAndFlush(CheckCar checkCar) {
        return checkCarRepository.saveAndFlush(checkCar);
    }

    @Override
    public List<CheckCar> findByAuthenticateId(Long id) {
        return checkCarRepository.findByAuthenticateId(id);
    }

    @Override
    public CheckCar findByCarId(Long id) {
        return checkCarRepository.findByCarId(id);
    }
}
