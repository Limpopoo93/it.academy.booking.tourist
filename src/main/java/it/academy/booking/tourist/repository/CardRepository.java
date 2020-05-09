package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByAuthenticateId(Long id);

    Card findByKeyNumberAndUsd(Integer keyNumber, Integer usd);
}
