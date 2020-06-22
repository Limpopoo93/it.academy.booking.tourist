package it.academy.booking.tourist.service;

import it.academy.booking.tourist.model.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    Company findById(Long id);

    void delete(Company company);

    List<Company> findAll();

    Company saveAndFlush(Company company);

}
