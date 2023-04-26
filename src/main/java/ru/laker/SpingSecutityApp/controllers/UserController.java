package ru.laker.SpingSecutityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.laker.SpingSecutityApp.models.User;
import ru.laker.SpingSecutityApp.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String viewUser(Principal principal, Model model) {
        User authorizedUser = userService.findByEmail(principal.getName());
        model.addAttribute("authorizedUser", authorizedUser);
        return "user";
    }
}
