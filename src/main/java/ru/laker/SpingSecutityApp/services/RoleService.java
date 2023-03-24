package ru.laker.SpingSecutityApp.services;

import ru.laker.SpingSecutityApp.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    List<Role> findRoleByRoleName(String roleName);

    void save(Role role);
}
