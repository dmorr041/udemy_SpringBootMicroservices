package com.udemy_springboot_microservices.mobileappws.ui.controller;

import com.udemy_springboot_microservices.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.udemy_springboot_microservices.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.udemy_springboot_microservices.mobileappws.ui.model.response.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")   // http:localhost:8080/users
public class UserController {

  // Temporary solution when you don't want to spin up and connect a DB
  Map<String, User> users;

  // GET @ http:localhost:8080/users/{userID}
  @GetMapping(path = "/{userID}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<User> getUser(@PathVariable String userID) {
    return (users.containsKey(userID)
      ? new ResponseEntity<>(users.get(userID), HttpStatus.OK)
      : new ResponseEntity<>(HttpStatus.NO_CONTENT));
  }

  // GET @ http://localhost:8080/users?page={page}&limit={limit}&sort={sort}
  @GetMapping
  public String getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
  ) {
    return "get users called with page = " + page + " and limit = " + limit + " and sorting method = " + sort;
  }

  // POST @ http://localhost:8080/users
  @PostMapping(consumes = {
    MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_VALUE
  }, produces = {
    MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_VALUE
  })
  public ResponseEntity<User> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
    String userID = UUID.randomUUID().toString();
    User user = new User(userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), userID);

    if(users == null) {
      users = new HashMap<>();
    }
    users.put(userID, user);

    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  // PUT @ http://localhost:8080/users/{userID}
  @PutMapping(path ="/{userID}", consumes = {
    MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_VALUE
  }, produces = {
    MediaType.APPLICATION_XML_VALUE,
    MediaType.APPLICATION_JSON_VALUE
  })
  public User updateUser(@PathVariable String userID, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {
    User storedUserDetails = users.get(userID);
    storedUserDetails.setFirstName(userDetails.getFirstName());
    storedUserDetails.setLastName(userDetails.getLastName());

    users.put(userID, storedUserDetails);

    return storedUserDetails;
  }

  @DeleteMapping(path = "/{userID}")
  public ResponseEntity<Void> deleteUser(@PathVariable String userID) {
    users.remove(userID);
    return ResponseEntity.noContent().build();
  }
}
