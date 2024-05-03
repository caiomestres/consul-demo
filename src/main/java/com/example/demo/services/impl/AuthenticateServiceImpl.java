package com.example.demo.services.impl;

import com.example.demo.services.AuthenticateService;
import com.example.demo.errorStuff.AuthenticationException;
import com.example.demo.errorStuff.BusinessException;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
  @Override
  public void auth() throws BusinessException {
    throw new AuthenticationException(Error.AUTHENTICATION_FAILED.getMessage());
  }

  @Getter
  private enum Error {
    AUTHENTICATION_FAILED("Erro ao autenticar");
    private final String message;

    Error(String message) {
      this.message = message;
    }
  }
}