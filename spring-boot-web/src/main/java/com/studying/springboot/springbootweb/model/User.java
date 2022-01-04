package com.studying.springboot.springbootweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {
  
  private String name;
  private String lastName;
  private String email;
  
  public User(String name, String lastName, String email) {
    this.name = name;
    this.lastName = lastName;
    this.email = email;
  }
  
}
