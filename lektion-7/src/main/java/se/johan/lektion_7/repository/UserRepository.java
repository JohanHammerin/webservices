package se.johan.lektion_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.johan.lektion_7.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
}
