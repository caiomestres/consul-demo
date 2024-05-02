package com.example.demo.errorStuff;

import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler({BusinessException.class})
  public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
    HttpStatus httpStatus = ex instanceof AuthenticationException ? HttpStatus.UNAUTHORIZED : HttpStatus.BAD_REQUEST;
    ApiError apiError = new ApiError(
        httpStatus,
        ex.getMessage(),
        Collections.singletonList(new Error(ex.getMessage(), ex.getTechnicalMessage()))
    );
    return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getHttpStatus());
  }

  @Getter
  static class Error {

    private String userMessage;
    private String technicalMessage;

    Error(String userMessage, String technicalMessage) {
      this.userMessage = userMessage;
      this.technicalMessage = technicalMessage;
    }
  }
}
