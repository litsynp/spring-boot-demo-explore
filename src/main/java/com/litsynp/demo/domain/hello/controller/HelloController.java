package com.litsynp.demo.domain.hello.controller;

import java.util.Locale;
import com.litsynp.demo.domain.hello.dto.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

  @Autowired
  private MessageSource messageSource;

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

  @GetMapping(path = "/hello-world-internationalized")
  public String helloWorldInternationalized() {
    return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
  }

}
