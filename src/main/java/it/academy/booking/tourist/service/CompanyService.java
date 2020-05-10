package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company findById(Long id);

    void delete(Company company);

    List<Company> findAll();

    Company saveAndFlush(Company company);

    List<Company> findByDelete(Boolean delete);

    List<Company> findByTownId(Long id);

    List<Company> findByAuthenticateId(Long id);

    Company findByName(String nameCompany);
}
