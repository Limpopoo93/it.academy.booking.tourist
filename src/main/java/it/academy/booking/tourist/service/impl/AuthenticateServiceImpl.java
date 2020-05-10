package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.AuthenticateRepository;
import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    @Autowired
    private AuthenticateRepository authenticateRepository;

    @Override
    @Transactional
    public Authenticate save(Authenticate authenticate) {
        return authenticateRepository.save(authenticate);
    }

    @Override
    public Authenticate findById(Long id) {
        return authenticateRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Authenticate authenticate) {
        authenticateRepository.delete(authenticate);
    }

    @Override
    public List<Authenticate> findAll() {
        return authenticateRepository.findAll();
    }

    @Override
    @Transactional
    public Authenticate saveAndFlush(Authenticate authenticate) {
        return authenticateRepository.saveAndFlush(authenticate);
    }

    @Override
    public Authenticate findByLoginByPassword(String login, String password) {
        return authenticateRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public Authenticate findByLogin(String login) {
        return authenticateRepository.findByLogin(login);
    }

    @Override
    public List<Authenticate> findByDeleteAndRoles(Boolean delete, String role) {
        return authenticateRepository.findByDeleteAndRoles(delete, role);
    }

    @Override
    public List<Authenticate> findByAcess(Boolean acess) {
        return authenticateRepository.findByAcess(acess);
    }
}
