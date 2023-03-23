package ru.laker.SpingSecutityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.laker.SpingSecutityApp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
//    Role findOneByRoleName(String role);
}
