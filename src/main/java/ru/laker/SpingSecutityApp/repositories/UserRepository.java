package ru.laker.SpingSecutityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.laker.SpingSecutityApp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.username = ?1")
    User findByEmail(String email);
}