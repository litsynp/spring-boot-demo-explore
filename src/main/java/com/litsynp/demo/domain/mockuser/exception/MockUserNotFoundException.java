package com.litsynp.demo.domain.mockuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MockUserNotFoundException extends RuntimeException {

  public MockUserNotFoundException(String message) {
    super(message);
  }

}
