package ru.laker.SpringSecurityApp.services;

import ru.laker.SpringSecurityApp.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);
}
