package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findByDelete(Boolean delete);

    List<Company> findByTownId(Long id);

    List<Company> findByAuthenticateId(Long id);

    Company findByName(String nameCompany);
}
