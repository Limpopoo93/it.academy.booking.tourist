package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Passport;

import java.util.List;

public interface PassportService {
    Passport save(Passport passport);

    Passport findById(Long id);

    void delete(Passport passport);

    List<Passport> findAll();

    Passport saveAndFlush(Passport passport);

    Passport findByAuthenticateId(Long id);

}
