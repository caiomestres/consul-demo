package com.example.demo.controllers;

import com.example.demo.Services.NumberService;
import com.example.demo.errorStuff.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberController {

  @Autowired
  NumberService numberService;

  @GetMapping("/check-bigger-5")
  public String checkBigger(@RequestParam int number) throws BusinessException {
    return numberService.checkBigger(number);
  }

  @GetMapping("/check-bigger-10-args")
  public String checkBiggerWithArgs(@RequestParam int number) throws BusinessException {
    return numberService.checkBiggerWithArgs(number);
  }
}
