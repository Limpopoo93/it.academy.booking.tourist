package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.model.CheckCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CheckCarRepository extends JpaRepository<CheckCar, Long> {
    @Query("select bd from CheckCar bd where :dateCheck between bd.dateCheck and bd.dateReturn or :dateReturn between bd.dateCheck and bd.dateReturn and bd.car.id = :id")
    List<CheckCar> findByCheckCar(@Param("dateCheck") Date dateCheck, @Param("dateReturn") Date dateReturn, Long id);
}
