package com.ejercicios.RS1.service;

import com.ejercicios.RS1.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  User user;

  public User postGreeting(User u) {

    user = u;
    return user;
  }

  public User getGreeting(User u) {

    return user;
  }

}
