package com.example.demo.ErrorStuff;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class BusinessException extends Exception {

  private final String message;

  private final String technicalMessage;

  public BusinessException(String identifier, String defaultMessage) {
    String exceptionMessage = ExceptionMessageUtil.getMessage(identifier, defaultMessage);
    this.message = String.format("%s {%s}", exceptionMessage, identifier);
    this.technicalMessage = exceptionMessage;
  }

  public BusinessException(String identifier, String defaultMessage, StackTraceElement[] technicalMessage) {
    this.message = defaultMessage;
    this.technicalMessage = Arrays.toString(technicalMessage);
  }

  public BusinessException(String identifier, String defaultMessage, Throwable cause) {
    super(defaultMessage, cause);
    this.message = defaultMessage;
    this.technicalMessage = defaultMessage;
  }

  public BusinessException(String identifier, String defaultMessage, StackTraceElement[] technicalMessage, Throwable cause) {
    super(defaultMessage, cause);
    this.message = defaultMessage;
    this.technicalMessage = Arrays.toString(technicalMessage);
  }
}
