package com.litsynp.demo.domain.post.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.litsynp.demo.domain.user.domain.User;

@Entity
public class Post {

  @Id
  @GeneratedValue
  private Integer id;

  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User user;

  public Post() {}

  public Post(Integer id, String description, User user) {
    this.id = id;
    this.description = description;
    this.user = user;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", description='" + getDescription() + "'" + "}";
  }

}
