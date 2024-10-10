package com.jgmedellin.Cryptrade.controller;

import com.jgmedellin.Cryptrade.exception.ValidationException;
import com.jgmedellin.Cryptrade.model.User;
import com.jgmedellin.Cryptrade.service.UserService;
import com.jgmedellin.Cryptrade.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private final UserService userService;

  @Autowired
  private final UserValidationService userValidationService;

  public AuthController(UserService userService, UserValidationService userValidationService) {
    this.userService = userService;
    this.userValidationService = userValidationService;
  }

  @PostMapping("/signup")
  public ResponseEntity<Object> signup(@RequestBody User user) {
    try{
      userValidationService.validateUser(user);
    } catch (ValidationException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    userService.saveUser(user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

}