package io.yadnyesh.controller;

import io.yadnyesh.controller.dto.UpdateUserDetailsRequestModel;
import io.yadnyesh.controller.dto.UserRequestModel;
import io.yadnyesh.controller.dto.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, UserRest> users;

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", defaultValue = "asc", required = false) String sort) {
        return "Get user was called with " + page + " pages and " + limit + " records per page and sorting " + sort ;
    }

    @GetMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUserById(@PathVariable String userId) {
        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
                 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserRequestModel userRequestModel) {
        UserRest returnUser = new UserRest();
        returnUser.setEmail(userRequestModel.getEmail());
        returnUser.setFirstName(userRequestModel.getFirstName());
        returnUser.setLastName(userRequestModel.getLastName());
        String userId = UUID.randomUUID().toString();
        returnUser.setUserId(userId);

        if(users == null) {
            users = new HashMap<>();
        }
        users.put(userId, returnUser);
        return new ResponseEntity<>(returnUser, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(updateUserDetailsRequestModel.getFirstName());
        storedUserDetails.setLastName(updateUserDetailsRequestModel.getLastName());
        users.put(userId, storedUserDetails);
        return storedUserDetails;
    }


    @DeleteMapping
    public String deleteUser() {
        return "Delete user was called";
    }
}
