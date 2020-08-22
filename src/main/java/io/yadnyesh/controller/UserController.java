package io.yadnyesh.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "Get user was called";
    }

    @GetMapping(path = "/{userId}")
    public String getUserById(@PathVariable String userId) {
        return "Get userId " + userId +" was called";
    }

    @PostMapping
    public String createUser() {
        return "Create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "Update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }
}
