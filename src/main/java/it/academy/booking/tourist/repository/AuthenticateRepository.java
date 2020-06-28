package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.model.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticateRepository extends JpaRepository<Authenticate, Long> {
    Authenticate findByLogin(String login);

    Authenticate findByLoginAndPassword(String login, String password);
}
