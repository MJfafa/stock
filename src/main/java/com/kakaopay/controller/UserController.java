package com.kakaopay.controller;

import com.kakaopay.exception.UserIdNotFoundException;
import com.kakaopay.model.User;
import com.kakaopay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return Optional.ofNullable(userService.getUserById(id));
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        if (user.getUserId() == null || user.getUserId().isEmpty()) {
            throw new UserIdNotFoundException("User ID is required.");
        }
        return userService.createUser(user);
    }
}
