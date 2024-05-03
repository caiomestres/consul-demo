package com.example.demo.controllers;

import com.example.demo.services.ConsulService;
import com.example.demo.controllers.requests.UpdateConsulRequest;
import com.example.demo.errorStuff.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/consul")
public class ConsulController {

  @Autowired
  ConsulService consulService;

  @GetMapping()
  public Map<String, String> getAllExceptions() {
    return consulService.getAllExceptions();
  }

  @PutMapping()
  public String updateConfig(@RequestBody UpdateConsulRequest updateConsulRequest) throws BusinessException {
    consulService.update(updateConsulRequest.key(), updateConsulRequest.value());
    return "Updated";
  }
}
