package com.jgmedellin.Cryptrade.controller;

import com.jgmedellin.Cryptrade.exception.ValidationException;
import com.jgmedellin.Cryptrade.service.UserService;
import com.jgmedellin.Cryptrade.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private final UserService userService;

  @Autowired
  private final UserValidationService userValidationService;

  public UserController(UserService userService, UserValidationService userValidationService) {
    this.userService = userService;
    this.userValidationService = userValidationService;
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
    try {
      userService.findUserById(userId);
      userService.deleteUserById(userId);
      return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    } catch (RuntimeException e) {
      return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
  }

}