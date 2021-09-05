package com.litsynp.demo.domain.hello.controller;

import com.litsynp.demo.domain.hello.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

  @GetMapping(path = "/hello")
  public String helloWorld() {
    return "Hello World";
  }


  @GetMapping(path = "/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello World!");
  }


  @GetMapping(path = "/hello-world-bean/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello World, %s", name));
  }
}
