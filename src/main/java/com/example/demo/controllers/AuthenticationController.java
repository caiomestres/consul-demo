package com.example.demo.controllers;

import com.example.demo.Services.AuthenticateService;
import com.example.demo.errorStuff.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  @Autowired
  AuthenticateService authenticateService;

  @GetMapping("/auth")
  public void throwExceptionTest() throws BusinessException {
    authenticateService.auth();
  }
}
