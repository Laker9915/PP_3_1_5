package ru.laker.SpingSecutityApp.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.laker.SpingSecutityApp.models.Role;
import ru.laker.SpingSecutityApp.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    List<User> findAll();

    User findOne(long id);

    void save(User user);

    void update(long id, User updatedUser, Role role);

    void delete(long id);
}
