package ru.laker.SpingSecutityApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.laker.SpingSecutityApp.models.User;
import ru.laker.SpingSecutityApp.services.RoleService;
import ru.laker.SpingSecutityApp.services.UserService;
//import ru.laker.SpingSecutityApp.util.UserValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
//    private final UserValidator userValidator;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
//        this.userValidator = userValidator;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "admin/showAllUsers";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        // Конкретный человек через сервис -> дао -> бд
        model.addAttribute("user", userService.findOne(id));
        return "admin/showUser";
    }

    @GetMapping("/new")
    public String getFormToNewUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "admin/new";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                           Model model) {
//        userValidator.validate(user, bindingResult);
        model.addAttribute("roles", roleService.findAll());
        if (bindingResult.hasErrors())
            return "admin/new";

        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String getFormToUpdateUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("roles", roleService.findAll());
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") long id, @RequestParam("role") String role, Model model) {
        model.addAttribute("roles", roleService.findAll());
//        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors())
            return "admin/edit";

//        userService.update(id, user, roleService.findOneByRoleName(role));
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
