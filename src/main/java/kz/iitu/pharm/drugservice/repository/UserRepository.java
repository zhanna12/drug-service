package kz.iitu.pharm.drugservice.repository;

import kz.iitu.pharm.drugservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // List<User> findAll();
    // User findUserByName(String username);

    User findByUsername(String username);

    Optional<User> findById(Long userId);
}
