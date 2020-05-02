package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}
