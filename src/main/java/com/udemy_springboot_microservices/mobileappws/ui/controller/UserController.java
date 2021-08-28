package com.udemy_springboot_microservices.mobileappws.ui.controller;

import com.udemy_springboot_microservices.mobileappws.ui.model.response.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")   // http:localhost:8080/users
public class UserController {

  //http:localhost:8080/users/{userID}
  @GetMapping(path = "/{userID}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
  public User getUser(@PathVariable String userID) {
    return new User("Quinn", "Morrison", "dmorr041@fiu.edu");
  }

  // http://localhost:8080/users?page={page}&limit={limit}&sort={sort}
  @GetMapping
  public String getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
  ) {
    return "get users called with page = " + page + " and limit = " + limit + " and sorting method = " + sort;
  }

  @PostMapping
  public String createUser() {
    return "create user called";
  }

  @PutMapping
  public String updateUser() {
    return "update user called";
  }

  @DeleteMapping
  public String deleteUser() {
    return "delete user called";
  }
}
