package com.udemy_springboot_microservices.mobileappws.ui.controller;

import com.udemy_springboot_microservices.mobileappws.ui.model.response.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")   // http:localhost:8080/users
public class UserController {

  //http:localhost:8080/users/{userID}
  @GetMapping(path = "/{userID}")
  public String getUser(@PathVariable String userID) {

    return "get user called with userID = " + userID;
  }

  // http://localhost:8080/users?page={page}&limit={limit}&sort={sort}
  @GetMapping
  public User getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
  ) {
    return new User("Quinn", "Morrison", "dmorr041@fiu.edu");
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
