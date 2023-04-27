package ru.laker.SpringSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.laker.SpringSecurityApp.models.User;
import ru.laker.SpringSecurityApp.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String viewUsers(Principal principal, Model model) {
        User authorizedUser = userService.findByEmail(principal.getName());
        model.addAttribute("authorizedUser", authorizedUser);
        return "admin";
    }
}
