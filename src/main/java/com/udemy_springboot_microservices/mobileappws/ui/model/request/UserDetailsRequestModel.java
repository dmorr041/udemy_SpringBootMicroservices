package com.udemy_springboot_microservices.mobileappws.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsRequestModel {
  private String firstName;
  private String lastName;
  private String email;
  private String password;
}
