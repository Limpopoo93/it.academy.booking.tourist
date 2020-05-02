package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.AuthenticateRepository;
import it.academy.booking.tourist.request.Authenticate;
import it.academy.booking.tourist.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    @Autowired
    private AuthenticateRepository authenticateRepository;

    public Authenticate save(Authenticate authenticate){
       return authenticateRepository.save(authenticate);
    }

    public Optional<Authenticate> findById(Long id){
        return authenticateRepository.findById(id);
    }

    public void delete(Authenticate authenticate){
        authenticateRepository.delete(authenticate);
    }

    public List<Authenticate> findAll(){
        return authenticateRepository.findAll();
    }

    public Authenticate saveAndFlush(Authenticate authenticate){
       return authenticateRepository.saveAndFlush(authenticate);
    }
}
