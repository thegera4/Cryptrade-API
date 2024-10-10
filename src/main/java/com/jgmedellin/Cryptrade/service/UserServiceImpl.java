package com.jgmedellin.Cryptrade.service;

import com.jgmedellin.Cryptrade.model.User;
import com.jgmedellin.Cryptrade.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) { this.userRepository = userRepository; }

  @Override
  public List<User> findAllUsers() { return userRepository.findAll(); }

  @Override
  public User findUserById(Long Id) {
    return userRepository.findById(Id).orElseThrow(() -> new RuntimeException("User not found"));
  }

  @Override
  public User findUserByEmail(String email) { return userRepository.findByEmail(email); }

  @Override
  public User saveUser(User user) { return userRepository.save(user); }

  @Override
  public void deleteUserById(Long Id) { userRepository.deleteById(Id); }

}