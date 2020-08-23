package io.yadnyesh.controller;

import io.yadnyesh.controller.dto.UserRequestModel;
import io.yadnyesh.controller.dto.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId) {
        UserRest userRest =  new UserRest("Yadnyesh", "Juvekar", "YB","yad@gmail.com");
        return new ResponseEntity<>(userRest, HttpStatus.OK);
    }

//    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
//                 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<UserRest> createUser(@RequestBody UserRequestModel userRequestModel) {
//        UserRest returnUser = new UserRest();
//        returnUser.setEmail("yad@gmail.com");
//        returnUser.setFirstName("Yadnyesh");
//        returnUser.setLastName("Juvekar");
//        returnUser.setUserId("YB");
//        return new ResponseEntity<>(returnUser, HttpStatus.CREATED);
//    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@RequestBody UserRequestModel userRequestModel) {
        UserRest returnUser = new UserRest();
        returnUser.setEmail("yad@gmail.com");
        returnUser.setFirstName("Yadnyesh");
        returnUser.setLastName("Juvekar");
        returnUser.setUserId("YB");
        return new ResponseEntity<>(returnUser, HttpStatus.OK);
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
