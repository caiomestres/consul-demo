package com.example.demo.services;

import com.example.demo.errorStuff.BusinessException;

public interface AuthenticateService {
  void auth() throws BusinessException;
}