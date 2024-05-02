package com.example.demo.Services;

import com.example.demo.errorStuff.BusinessException;

public interface NumberService {
  String checkBigger(int number) throws BusinessException;

  String checkBiggerWithArgs(int number) throws BusinessException;

}