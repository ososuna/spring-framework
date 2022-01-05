package com.studying.springboot.springbootweb.controller;

import java.util.Arrays;
import java.util.List;

import com.studying.springboot.springbootweb.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

  @GetMapping({"", "/index", "/", "/home"})
  public String index(Model model) {
    model.addAttribute("title", "Hello Spring Boot!");
    return "index";
  }

  @GetMapping("/profile")
  public String profile(Model model) {
    
    User user = new User();
    user.setName("Andy");
    user.setLastName("Alonso");
    user.setEmail("vally@test.com");
    
    model.addAttribute("user", user);
    
    StringBuilder data = new StringBuilder();
    
    data.append(user.getName());
    data.append(" ");
    data.append(user.getLastName());
    model.addAttribute("title", "Hello: ".concat(data.toString()));
    
    return "profile";
  }

  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("title", "Users list");
    return "list";
  }

  @ModelAttribute("users")
  public List<User> getUsers() {
    List<User> users = Arrays.asList(
      new User("Andy", "Alonso", "vally@test.com"),
      new User("John", "Yakimeshi", "john@test.com"),
      new User("Jefferson", "Gutierritos", "john@test.com")
    );
    return users;
  }

}
