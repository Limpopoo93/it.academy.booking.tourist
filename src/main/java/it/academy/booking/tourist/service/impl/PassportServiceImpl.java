package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.model.Passport;
import it.academy.booking.tourist.repository.PassportRepository;
import it.academy.booking.tourist.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {
    @Autowired
    private PassportRepository passportRepository;

    @Override
    @Transactional
    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    @Override
    public Passport findById(Long id) {
        return passportRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Passport passport) {
        passportRepository.delete(passport);
    }

    @Override
    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    @Override
    @Transactional
    public Passport saveAndFlush(Passport passport) {
        return passportRepository.saveAndFlush(passport);
    }

}
