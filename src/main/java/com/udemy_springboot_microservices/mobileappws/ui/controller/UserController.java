package com.udemy_springboot_microservices.mobileappws.ui.controller;

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
  public String getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort
  ) {
    return "get user was called for page " + page + " with limit of " + limit + " and sorting method = " + sort;
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
