package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.model.CheckCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckCarRepository extends JpaRepository<CheckCar, Long> {

}
