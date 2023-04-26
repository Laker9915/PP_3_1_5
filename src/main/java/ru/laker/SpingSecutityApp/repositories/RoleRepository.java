package ru.laker.SpingSecutityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.laker.SpingSecutityApp.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
