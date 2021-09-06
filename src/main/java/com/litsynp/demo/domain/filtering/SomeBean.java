package com.litsynp.demo.domain.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean {

  private String field1;

  private String field2;

  private String field3;

  public SomeBean() {}

  public SomeBean(String field1, String field2, String field3) {
    this.field1 = field1;
    this.field2 = field2;
    this.field3 = field3;
  }

  public String getField1() {
    return this.field1;
  }

  public void setField1(String field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return this.field2;
  }

  public void setField2(String field2) {
    this.field2 = field2;
  }

  public String getField3() {
    return this.field3;
  }

  public void setField3(String field3) {
    this.field3 = field3;
  }

  public SomeBean field1(String field1) {
    setField1(field1);
    return this;
  }

  public SomeBean field2(String field2) {
    setField2(field2);
    return this;
  }

  public SomeBean field3(String field3) {
    setField3(field3);
    return this;
  }

  @Override
  public String toString() {
    return "{" + " field1='" + getField1() + "'" + ", field2='" + getField2() + "'" + ", field3='"
        + getField3() + "'" + "}";
  }
}
