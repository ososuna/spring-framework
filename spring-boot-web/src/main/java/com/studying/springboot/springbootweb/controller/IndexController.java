package com.studying.springboot.springbootweb.controller;

import com.studying.springboot.springbootweb.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    model.addAttribute("user", user);
    StringBuilder data = new StringBuilder();
    data.append(user.getName());
    data.append(" ");
    data.append(user.getLastName());
    model.addAttribute("title", "Hello: ".concat(data.toString()));
    return "profile";
  }

}
