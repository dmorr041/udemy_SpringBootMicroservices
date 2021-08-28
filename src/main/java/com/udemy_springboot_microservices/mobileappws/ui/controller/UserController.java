package com.udemy_springboot_microservices.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")   // http:localhost:8080/users
public class UserController {

  @GetMapping(path = "/{userID}")
  public String getUser(@PathVariable String userID) {

    return "get user called with userID = " + userID;
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
