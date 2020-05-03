package it.academy.booking.tourist.service.impl;

import it.academy.booking.tourist.repository.CompanyRepository;
import it.academy.booking.tourist.request.Company;
import it.academy.booking.tourist.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    @Transactional
    public Company save(Company company) {
        return companyRepository.save(company);
    }
    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }
    @Override
    @Transactional
    public void delete(Company company) {
        companyRepository.delete(company);
    }
    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    @Override
    @Transactional
    public Company saveAndFlush(Company company) {
        return companyRepository.saveAndFlush(company);
    }
}
