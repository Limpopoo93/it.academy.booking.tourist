package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Authenticate;

import java.util.List;
import java.util.Optional;

public interface AuthenticateService {
    Authenticate save(Authenticate authenticate);
    Optional<Authenticate> findById(Long id);
    void delete(Authenticate authenticate);
    List<Authenticate> findAll();
    Authenticate saveAndFlush(Authenticate authenticate);
}
