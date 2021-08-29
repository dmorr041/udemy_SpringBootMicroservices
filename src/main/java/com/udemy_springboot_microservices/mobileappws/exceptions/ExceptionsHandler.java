package com.udemy_springboot_microservices.mobileappws.exceptions;

import com.udemy_springboot_microservices.mobileappws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<Object> handleAnyException(Exception err, WebRequest request) {
    String errorMessage = err.getLocalizedMessage();
    if (errorMessage == null) errorMessage = err.toString();

    ErrorMessage error = new ErrorMessage(new Date(), errorMessage);

    return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
  public ResponseEntity<Object> handleSpecificException(Exception err, WebRequest request) {
    String errorMessage = err.getLocalizedMessage();
    if (errorMessage == null) errorMessage = err.toString();

    ErrorMessage error = new ErrorMessage(new Date(), errorMessage);

    return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
