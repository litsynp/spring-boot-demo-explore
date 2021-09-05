package com.litsynp.demo.domain.hello.dto;

public class HelloWorldBean {
  private String message;

  @Override
  public String toString() {
    return "{" + " message='" + getMessage() + "'" + "}";
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public HelloWorldBean(String message) {
    this.message = message;
  }
}
