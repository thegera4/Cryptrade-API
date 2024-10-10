package com.jgmedellin.Cryptrade.repository;

import com.jgmedellin.Cryptrade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  // Custom method to find user by email
  User findByEmail(String email);

}