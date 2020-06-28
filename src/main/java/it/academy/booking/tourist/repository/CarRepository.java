package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c join Company cm on cm.id = c.company.id where cm.id in (select cm.id from Company cm join Town tw on cm.town.id = tw.id where tw.id in (SELECT tw.id from Town tw where tw.town = :town and tw.country.country = :country))")
    List<Car> findByAllCar(@Param("town") String town, @Param("country") String country);
}
