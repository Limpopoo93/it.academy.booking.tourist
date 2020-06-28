package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.model.CheckCar;
import it.academy.booking.tourist.repository.CheckCarRepository;
import it.academy.booking.tourist.service.CheckCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public List<CheckCar> findByCheckCar(Date dateCheck, Date dateReturn, Long id) {
        return checkCarRepository.findByCheckCar(dateCheck, dateReturn, id);
    }

}
