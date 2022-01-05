package com.studying.springboot.springbootweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
  
  @GetMapping("/")
  public String index() {
    return "params/index";
  }

  @GetMapping("/string")
  public String param(@RequestParam(required=false, defaultValue="some value...") String text, Model model) {
    model.addAttribute("result", "Text sent is: " + text);
    return "params/ver";
  }

  @GetMapping("/mix-params")
  public String param(
    @RequestParam(required=false, defaultValue="some value...") String text,
    @RequestParam(required=false, defaultValue="some value...") String number,
    Model model
  ) {
    model.addAttribute("result", "Text is " + "'" + text + "'" + ", and number is " + "'" + number + "'" );
    return "params/ver";
  }

  @GetMapping("/mix-params-request")
  public String param(HttpServletRequest request, Model model) {
    
    String text = request.getParameter("text");
    Integer number;
    
    try {
      number = Integer.parseInt(request.getParameter("number"));
    } catch (NumberFormatException e) {
      number = 0;
    }    
    
    model.addAttribute("result", "Text is " + "'" + text + "'" + ", and number is " + "'" + number + "'" );
    
    return "params/ver";
  }

}
