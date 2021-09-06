package com.litsynp.demo.domain.versioning;

public class Name {

  private String firstName;
  private String lastName;

  public Name() {}

  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Name firstName(String firstName) {
    setFirstName(firstName);
    return this;
  }

  public Name lastName(String lastName) {
    setLastName(lastName);
    return this;
  }

}
