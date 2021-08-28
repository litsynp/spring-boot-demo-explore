package com.litsynp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

  @GetMapping("/hello")
  public String getHello() {
    return "hello";
  }
}
