package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.Authenticate;

import java.util.List;

public interface AuthenticateService {
    Authenticate save(Authenticate authenticate);

    Authenticate findById(Long id);

    void delete(Authenticate authenticate);

    List<Authenticate> findAll();

    Authenticate saveAndFlush(Authenticate authenticate);

}
