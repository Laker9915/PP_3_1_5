package ru.laker.SpingSecutityApp.dbInit;

import org.springframework.stereotype.Component;
import ru.laker.SpingSecutityApp.models.Role;
import ru.laker.SpingSecutityApp.models.User;
import ru.laker.SpingSecutityApp.services.RoleService;
import ru.laker.SpingSecutityApp.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Component
public class DbInit {

    private final UserService userService;

    private final RoleService roleService;

    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void postConstruct() {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));
        userService.save(new User("admin", "admin", 24, "admin@mail.ru",
                "admin", new HashSet<>(roleService.findAll())));
        userService.save(new User("user", "user", 24, "user@mail.ru",
                "user", new HashSet<>(roleService.findRoleByRoleName("ROLE_USER"))));
    }
}
