package it.academy.booking.tourist.service;

import it.academy.booking.tourist.request.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company save(Company company);
    Optional<Company> findById(Long id);
    void delete(Company company);
    List<Company> findAll();
    Company saveAndFlush(Company company);
}
