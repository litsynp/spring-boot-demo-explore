package com.litsynp.demo.domain.versioning;

public class PersonV1 {

  private String name;

  public PersonV1() {}

  public PersonV1(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PersonV1 name(String name) {
    setName(name);
    return this;
  }

}
