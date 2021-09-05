package com.litsynp.demo.domain.user.model;

import java.util.Date;

public class User {

  private Integer id;

  private String name;

  private Date birthDate;


  protected User() {}

  public User(Integer id, String name, Date birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return this.birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", birthDate='"
        + getBirthDate() + "'" + "}";
  }

}
