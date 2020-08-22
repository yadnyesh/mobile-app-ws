package io.yadnyesh.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", defaultValue = "asc", required = false) String sort) {
        return "Get user was called with " + page + " pages and " + limit + " records per page and sorting " + sort ;
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
