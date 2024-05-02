package com.example.demo.Services;

import com.example.demo.errorStuff.BusinessException;

public interface AuthenticateService {
  void auth() throws BusinessException;
}