package ru.laker.SpringSecurityApp.dbInit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.laker.SpringSecurityApp.models.Role;
import ru.laker.SpringSecurityApp.models.User;
import ru.laker.SpringSecurityApp.services.RoleService;
import ru.laker.SpringSecurityApp.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit implements ApplicationRunner {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DbInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public void run(ApplicationArguments args) {

        User admin = new User("admin", "admin", 24, "admin@mail.ru", "test");
        User user = new User("user", "user", 24, "user@mail.ru", "test");
        User superAdmin = new User("superAdmin", "superAdmin", 24, "superAdmin@mail.ru", "test");


        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        admin.setRoles(new HashSet<>(Set.of(adminRole)));
        user.setRoles(new HashSet<>(Set.of(userRole)));
        superAdmin.setRoles(new HashSet<>(Set.of(adminRole, userRole)));

        roleService.save(adminRole);
        roleService.save(userRole);

        userService.save(admin);
        userService.save(user);
        userService.save(superAdmin);

    }
}
