package se.johan.lektion_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.johan.lektion_8.model.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
}
