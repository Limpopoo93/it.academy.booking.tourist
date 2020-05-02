package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.PersonalInformation;

import java.util.List;
import java.util.Optional;

public interface PersonalInformationService {
    PersonalInformation save(PersonalInformation personalInformation);
    Optional<PersonalInformation> findById(Long id);
    void delete(PersonalInformation personalInformation);
    List<PersonalInformation> findAll();
    PersonalInformation saveAndFlush(PersonalInformation personalInformation);
}
