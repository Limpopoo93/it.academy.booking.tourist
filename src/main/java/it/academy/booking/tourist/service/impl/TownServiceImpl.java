package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.TownRepository;
import it.academy.booking.tourist.request.Town;
import it.academy.booking.tourist.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {
    @Autowired
    private TownRepository townRepository;

    public Town save(Town town){
        return townRepository.save(town);
    }

    public Optional<Town> findById(Long id){
        return townRepository.findById(id);
    }

    public void delete(Town town){
        townRepository.delete(town);
    }

    public List<Town> findAll(){
        return townRepository.findAll();
    }

    public Town saveAndFlush(Town town){
        return townRepository.saveAndFlush(town);
    }
}
