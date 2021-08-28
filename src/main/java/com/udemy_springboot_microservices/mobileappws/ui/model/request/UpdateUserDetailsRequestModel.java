package com.udemy_springboot_microservices.mobileappws.ui.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UpdateUserDetailsRequestModel {
  @NotNull(message = "First name cannot be null")
  @Size(min = 2, max = 50, message = "Names must be between 2-50 characters")
  private String firstName;

  @NotNull(message = "Last name cannot be null")
  @Size(min = 2, max = 50, message = "Names must be between 2-50 characters")
  private String lastName;
}
