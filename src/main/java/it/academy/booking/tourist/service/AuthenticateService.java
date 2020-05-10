package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Authenticate;

import java.util.List;

public interface AuthenticateService {
    Authenticate save(Authenticate authenticate);

    Authenticate findById(Long id);

    void delete(Authenticate authenticate);

    List<Authenticate> findAll();

    Authenticate saveAndFlush(Authenticate authenticate);

    Authenticate findByLoginByPassword(String login, String password);

    Authenticate findByLogin(String login);

    List<Authenticate> findByDeleteAndRoles(Boolean delete, String role);

    List<Authenticate> findByAcess(Boolean acess);
}
