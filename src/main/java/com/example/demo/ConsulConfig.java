package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@ConfigurationProperties
@Getter
public class ConsulConfig {

  private final Map<String, ExceptionDetail> abacaxi = new HashMap<>();

  public Map<String, ExceptionDetail> getAbacaxi() {
    return abacaxi;
  }
  @Getter
  @Setter
  public static class ExceptionDetail {
    private String message;
    private Integer statusCode;
  }

}