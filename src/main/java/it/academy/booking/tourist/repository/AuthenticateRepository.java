package it.academy.booking.tourist.repository;

import it.academy.booking.tourist.request.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthenticateRepository extends JpaRepository<Authenticate, Long> {
    Authenticate findByLoginAndPassword(String login, String password);

    Authenticate findByLogin(String login);

    List<Authenticate> findByDeleteAndRoles(Boolean delete, String role);

    List<Authenticate> findByAcess(Boolean acess);

}
