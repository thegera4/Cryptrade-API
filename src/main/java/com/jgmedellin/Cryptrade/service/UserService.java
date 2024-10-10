package com.jgmedellin.Cryptrade.service;

import com.jgmedellin.Cryptrade.model.User;
import java.util.List;

public interface UserService {

  List<User> findAllUsers();

  User findUserById(Long Id);

  User findUserByEmail(String email);

  void saveUser(User user);

  void deleteUserById(Long Id);

}