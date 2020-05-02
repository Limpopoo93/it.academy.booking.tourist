package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.PersonalInformationRepository;
import it.academy.booking.tourist.request.PersonalInformation;
import it.academy.booking.tourist.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalInformationServiceImpl implements PersonalInformationService {
    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public PersonalInformation save(PersonalInformation personalInformation){
        return personalInformationRepository.save(personalInformation);
    }

    public Optional<PersonalInformation> findById(Long id){
        return personalInformationRepository.findById(id);
    }

    public void delete(PersonalInformation personalInformation){
        personalInformationRepository.delete(personalInformation);
    }

    public List<PersonalInformation> findAll(){
        return personalInformationRepository.findAll();
    }

    public PersonalInformation saveAndFlush(PersonalInformation personalInformation){
        return personalInformationRepository.saveAndFlush(personalInformation);
    }
}
