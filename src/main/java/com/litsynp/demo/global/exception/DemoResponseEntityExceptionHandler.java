package com.litsynp.demo.global.exception;

import java.net.http.HttpHeaders;
import java.util.Date;
import com.litsynp.demo.domain.mockuser.exception.MockUserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class DemoResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(MockUserNotFoundException.class)
  public final ResponseEntity<Object> handleMockUserNotFoundException(MockUserNotFoundException ex,
      WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  // @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatus status, WebRequest request) {
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());
    return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
