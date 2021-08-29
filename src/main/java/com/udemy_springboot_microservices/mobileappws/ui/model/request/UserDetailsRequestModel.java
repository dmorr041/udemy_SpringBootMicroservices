package com.udemy_springboot_microservices.mobileappws.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *  This is the object you send to /users via createUser()
 */
@Data
@AllArgsConstructor
public class UserDetailsRequestModel {
  @NotNull(message = "First name cannot be null")
  @Size(min = 2, max = 50, message = "Names must be between 2-50 characters")
  private String firstName;

  @NotNull(message = "Last name cannot be null")
  @Size(min = 2, max = 50, message = "Names must be between 2-50 characters")
  private String lastName;

  @NotNull(message = "Email cannot be null")
  @Email
  private String email;

  // TODO: Change this to not be plain text
  @NotNull(message = "Password cannot be null")
  @Size(min = 8, max = 32, message = "Password must be between 8-32 characters")
  private String password;
}
