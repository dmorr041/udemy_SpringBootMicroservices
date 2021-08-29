package com.udemy_springboot_microservices.mobileappws.ui.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private String firstName;
  private String lastName;
  private String email;
  private String userID;

  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }
}
