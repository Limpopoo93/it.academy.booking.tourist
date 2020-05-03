package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CountryRepository;
import it.academy.booking.tourist.request.Country;
import it.academy.booking.tourist.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    @Transactional
    public Country save(Country country) {
        return countryRepository.save(country);
    }
    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(Country country) {
        countryRepository.delete(country);
    }
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
    @Override
    @Transactional
    public Country saveAndFlush(Country country) {
        return countryRepository.saveAndFlush(country);
    }
}
