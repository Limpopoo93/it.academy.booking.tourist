package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.request.Passport;

import java.util.List;
import java.util.Optional;

public interface PassportService {
    Passport save(Passport passport);

    Optional<Passport> findById(Long id);

    void delete(Passport passport);

    List<Passport> findAll();

    Passport saveAndFlush(Passport passport);

    Passport findByAuthenticateId(Long id);

    List<Authenticate> findByDelete(Boolean delete);
}
