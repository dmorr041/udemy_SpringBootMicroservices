package com.udemy_springboot_microservices.mobileappws.exceptions;

public class UserServiceException extends RuntimeException {

  private static final long serialVersionUID = -4364164755715980211L;

  public UserServiceException(String message) {
    super(message);
  }
}
