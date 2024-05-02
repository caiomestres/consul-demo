package com.example.demo.errorStuff;

public class AuthenticationException extends BusinessException {
  public AuthenticationException(String secureMessage) {
    super(secureMessage);
  }
}
