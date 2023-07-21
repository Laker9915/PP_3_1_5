package ru.laker.SpringSecurityApp.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.laker.SpringSecurityApp.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(User updatedUser);

    void delete(long id);
}
