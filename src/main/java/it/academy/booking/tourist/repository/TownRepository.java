package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
    List<Town> findByDelete(Boolean delete);

    List<Town> findByNameTown(String town);

    List<Town> findByCountryId(Long id);
}
