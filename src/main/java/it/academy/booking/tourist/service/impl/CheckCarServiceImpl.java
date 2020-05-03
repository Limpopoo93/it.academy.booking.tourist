package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CheckCarRepository;
import it.academy.booking.tourist.request.CheckCar;
import it.academy.booking.tourist.service.CheckCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    public Optional<CheckCar> findById(Long id) {
        return checkCarRepository.findById(id);
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
}
