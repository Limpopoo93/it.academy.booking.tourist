package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByDeleteAndCompanyId(Boolean delete, Long id);

    List<Car> findByCompanyId(Long id);
}
