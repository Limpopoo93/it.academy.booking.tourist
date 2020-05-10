package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByDelete(Boolean delete);
}
