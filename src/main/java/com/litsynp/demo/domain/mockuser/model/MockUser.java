package com.litsynp.demo.domain.mockuser.model;

import java.util.Date;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the mock user.")
public class MockUser {

  private Integer id;

  @Size(min = 2, message = "Name should have at least 2 characters")
  @ApiModelProperty(notes = "Name should have at least 2 characters")
  private String name;

  @Past
  @ApiModelProperty(notes = "Birth date should be in the past")
  private Date birthDate;

  protected MockUser() {}

  public MockUser(Integer id, String name, Date birthDate) {
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
