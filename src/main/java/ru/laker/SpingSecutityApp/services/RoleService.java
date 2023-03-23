package ru.laker.SpingSecutityApp.services;

import ru.laker.SpingSecutityApp.models.Role;

import java.util.List;

public interface RoleService {
//    Role findOneByRoleName(String role);

    List<Role> findAll();
}
