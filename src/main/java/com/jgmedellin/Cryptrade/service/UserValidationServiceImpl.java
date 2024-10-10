package com.jgmedellin.Cryptrade.service;

import com.jgmedellin.Cryptrade.exception.ValidationException;
import com.jgmedellin.Cryptrade.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidationServiceImpl implements UserValidationService {

  @Autowired
  private final UserService userService;

  private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

  private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&!+=])(?=\\S+$).{8,}$";

  public UserValidationServiceImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void validateUser(User user) {
    String email = user.getEmail();
    String password = user.getPassword();

    if (email == null || email.isEmpty()) {
      throw new ValidationException("User email is required.");
    }
    if (password == null || password.isEmpty()) {
      throw new ValidationException("User password is required.");
    }
    if (!email.matches(EMAIL_REGEX)) {
      throw new ValidationException("Invalid email format.");
    }
    if (userService.findUserByEmail(email) != null) {
      throw new ValidationException("User already exists.");
    }
    if (!password.matches(PASSWORD_REGEX)) {
      throw new ValidationException("Invalid password format.");
    }

  }

}