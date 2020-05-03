package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.TownRepository;
import it.academy.booking.tourist.request.Town;
import it.academy.booking.tourist.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {
    @Autowired
    private TownRepository townRepository;
    @Override
    @Transactional
    public Town save(Town town) {
        return townRepository.save(town);
    }
    @Override
    public Optional<Town> findById(Long id) {
        return townRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(Town town) {
        townRepository.delete(town);
    }
    @Override
    public List<Town> findAll() {
        return townRepository.findAll();
    }
    @Override
    @Transactional
    public Town saveAndFlush(Town town) {
        return townRepository.saveAndFlush(town);
    }
}
