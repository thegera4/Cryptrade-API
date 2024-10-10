package com.jgmedellin.Cryptrade.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jgmedellin.Cryptrade.domain.TwoFactorAuth;
import com.jgmedellin.Cryptrade.domain.UserRole;
import jakarta.persistence.*;
import lombok.Data;

@Entity // Specifies that the class is an entity and is mapped to a database table
@Data // Generates all the boilerplate code (getters, setters, constructors, etc.)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String fullName;

  private String email;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Hides the password when serializing the object to JSON
  private String password;

  private UserRole role = UserRole.ROLE_CUSTOMER; // Default role is ROLE_CUSTOMER

  @Embedded // Embeds the TwoFactorAuth object in the User table
  private TwoFactorAuth twoFactorAuth = new TwoFactorAuth();

}