package ru.laker.SpingSecutityApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.laker.SpingSecutityApp.models.User;
import ru.laker.SpingSecutityApp.services.UserService;

import java.security.Principal;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final UserService userService;

    @Autowired
    public RestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listUser() {
        return userService.findAll();
    }

    @GetMapping("users/{id}")
    public User oneUser(@PathVariable("id") int id) {
        return userService.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(HttpStatus.OK);
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
