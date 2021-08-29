package com.udemy_springboot_microservices.mobileappws.shared;

import java.util.UUID;

public class Utils {
  public static String generateUserID() {
    return UUID.randomUUID().toString();
  }
}
