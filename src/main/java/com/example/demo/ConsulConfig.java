package com.example.demo;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@ConfigurationProperties
@Getter
public class ConsulConfig {

  private final Map<String, String> abacaxi = new HashMap<>();

  public Map<String, String> getAbacaxi() {
    return abacaxi;
  }

}