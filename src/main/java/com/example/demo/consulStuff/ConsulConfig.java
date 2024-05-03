package com.example.demo.consulStuff;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties
@Getter
public class ConsulConfig {

  private final Map<String, String> exception = new HashMap<>();

  public Map<String, String> getException() {
    return exception;
  }

}