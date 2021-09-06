package com.litsynp.demo.domain.user.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;


  private String name;

  private String role;

  protected User() {}

  public User(String name, String role) {
    this.name = name;
    this.role = role;
  }

  public long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", role='" + getRole()
        + "'" + "}";
  }

}
