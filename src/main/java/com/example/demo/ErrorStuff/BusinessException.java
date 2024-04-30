package com.example.demo.ErrorStuff;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class BusinessException extends Exception {

  private final String message;

  private final String technicalMessage;

  private String identifier;

  public BusinessException(String secureMessage) {
    this.message = secureMessage;
    this.technicalMessage = secureMessage;
  }

  public BusinessException(String identifier, String defaultMessage, String... args) {
    String exceptionMessage = formatMessageForException(identifier,defaultMessage,args);
    this.identifier = identifier;
    this.message = exceptionMessage;
    this.technicalMessage = exceptionMessage;
  }

  public BusinessException(String secureMessage, StackTraceElement[] technicalMessage) {
    this.message = secureMessage;
    this.technicalMessage = Arrays.toString(technicalMessage);
  }

  public BusinessException(String identifier,
                           String defaultMessage,
                           StackTraceElement[] technicalMessage,
                           String... args) {
    this.identifier = identifier;
    this.message = formatMessageForException(identifier,defaultMessage,args);
    this.technicalMessage = Arrays.toString(technicalMessage);
  }

  public BusinessException(String secureMessage, Throwable cause) {
    super(secureMessage, cause);
    this.message = secureMessage;
    this.technicalMessage = secureMessage;
  }

  public BusinessException(String identifier, String defaultMessage, Throwable cause,String... args) {
    super(formatMessageForException(identifier, defaultMessage, args), cause);
    String exceptionMessage = formatMessageForException(identifier, defaultMessage, args);
    this.identifier = identifier;
    this.message = exceptionMessage;
    this.technicalMessage = exceptionMessage;
  }

  public BusinessException(String secureMessage, StackTraceElement[] technicalMessage, Throwable cause) {
    super(secureMessage, cause);
    this.message = secureMessage;
    this.technicalMessage = Arrays.toString(technicalMessage);
  }

  public BusinessException(String identifier,
                           String defaultMessage,
                           StackTraceElement[] technicalMessage,
                           Throwable cause,
                           String... args) {
    super(formatMessageForException(identifier, defaultMessage,args), cause);
    this.identifier = identifier;
    this.message = formatMessageForException(identifier, defaultMessage,args);
    this.technicalMessage = Arrays.toString(technicalMessage);
  }

  private static String formatMessageForException(String identifier, String defaultMessage, String... args) {
    String formattedMessage = formatMessageRecursively(ExceptionMessageUtil.getMessage(identifier, defaultMessage), args, 0);
    return String.format("%s {%s}", formattedMessage, identifier);
  }

  private static String formatMessageRecursively(String message, String[] args, int index) {
    if (args == null || index >= args.length) {
      return message;
    }
    message = message.replaceFirst("%s", args[index]);
    return formatMessageRecursively(message, args, index + 1);
  }
}
