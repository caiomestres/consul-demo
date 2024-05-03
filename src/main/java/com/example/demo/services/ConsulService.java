package com.example.demo.services;

import com.example.demo.errorStuff.BusinessException;

import java.util.Map;

public interface ConsulService {
  Map<String, String> getAllExceptions();

  void update(String key, String value) throws BusinessException;
}