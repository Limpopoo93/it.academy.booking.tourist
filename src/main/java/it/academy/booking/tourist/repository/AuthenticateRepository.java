package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticateRepository extends JpaRepository<Authenticate, Long> {
    Authenticate findByLoginAndPassword(String login, String password);

    Authenticate findByLogin(String login);
}
