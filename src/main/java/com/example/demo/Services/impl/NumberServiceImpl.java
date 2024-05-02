package com.example.demo.Services.impl;

import com.example.demo.Services.NumberService;
import com.example.demo.errorStuff.BusinessException;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class NumberServiceImpl implements NumberService {


  @Override
  public String checkBigger(int number) throws BusinessException {
    if (number < 5) {
      throw new BusinessException("rn001", Error.NUMBER_MUST_BE_AT_LEAST.getMessage());
    }
    return "É maior que 5";
  }

  @Override
  public String checkBiggerWithArgs(int number) throws BusinessException {
    if (number < 10) {
      throw new BusinessException("rn010", Error.NUMBER_MUST_BE_AT_LEAST.getMessage(), "5", "6", "7");
    }
    return "É maior que 10";
  }

  @Getter
  private enum Error {
    NUMBER_MUST_BE_AT_LEAST("Number must be at least 6 or bigger"),
    TRY_NUMBERS("Try the numbers %s , %s or %s");
    private final String message;

    Error(String message) {
      this.message = message;
    }
  }
}