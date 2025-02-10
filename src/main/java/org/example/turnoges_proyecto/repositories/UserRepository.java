package org.example.turnoges_proyecto.repositories;


import org.example.turnoges_proyecto.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    Optional<User> findByUsername(String username);
}