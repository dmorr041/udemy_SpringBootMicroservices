package com.udemy_springboot_microservices.mobileappws.userservice;

import com.udemy_springboot_microservices.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.udemy_springboot_microservices.mobileappws.ui.model.response.User;

public interface UserService {
  public User createUser(UserDetailsRequestModel userDetails);
}
