package com.example.demo.services;

import com.example.demo.errorStuff.BusinessException;

public interface NumberService {
  String checkBigger(int number) throws BusinessException;

  String checkBiggerWithArgs(int number) throws BusinessException;

}