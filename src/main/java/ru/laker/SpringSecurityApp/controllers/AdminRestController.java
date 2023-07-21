package ru.laker.SpringSecurityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.laker.SpringSecurityApp.models.User;
import ru.laker.SpringSecurityApp.services.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {
    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getListUser() {
        return userService.findAll();
    }

    @GetMapping("users/{id}")
    public User getOneUser(@PathVariable("id") int id) {
        return userService.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.save(user);
            return ResponseEntity.ok("ok");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/users")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User updUser) {
        userService.update(updUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/users/authUser")
    public ResponseEntity<User> authUser(Principal principal) {
        User user = userService.findByEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
