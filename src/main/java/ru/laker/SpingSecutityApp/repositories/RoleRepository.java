package ru.laker.SpingSecutityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.laker.SpingSecutityApp.models.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findRoleByRoleName(String roleName);

    List<Role> findAll();
}
