package com.studying.springboot.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequestMapping("/variables")
public class PathVariableController {
  
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("title", "Send params to path (@PathVariable)");
    return "variables/index";
  }

  @GetMapping("/string/{text}")
  public String variables(@PathVariable String text, Model model) {
    model.addAttribute("title", "Get params from path (@PathVariable)");
    model.addAttribute("result", "Text sent in path is: " + text);
    return "variables/ver";
  }

  @GetMapping("/string/{text}/{number}")
  public String variables(@PathVariable String text, @PathVariable Integer number, Model model) {
    model.addAttribute("title", "Get params from path (@PathVariable)");
    model.addAttribute("result", "Text sent in path is: " + text + ", and number is: " + number);
    return "variables/ver";
  }
  

}
