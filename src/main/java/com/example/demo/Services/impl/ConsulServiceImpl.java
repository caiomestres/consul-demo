package com.example.demo.Services.impl;

import com.example.demo.ConsulConfig;
import com.example.demo.Services.ConsulService;
import com.example.demo.errorStuff.BusinessException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class ConsulServiceImpl implements ConsulService {
  @Value("${consul.url}")
  private String consulUrl;
  @Value("${spring.cloud.consul.config.prefixes}")
  private String prefixes;
  @Value("${spring.cloud.consul.config.default-context}")
  private String context;

  @Autowired
  private ConsulConfig consulConfig;

  private final RestTemplate restTemplate;

  @Autowired
  public ConsulServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Map<String, String> getAllExceptions() {
    return consulConfig.getException();
  }

  @Override
  public void update(String key, String value) throws BusinessException {
    try {

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
      String url = String.format("%s/%s/%s/exception/%s", consulUrl, prefixes, context, key);
      HttpEntity<String> requestEntity = new HttpEntity<>(value, headers);
      restTemplate.put(url, requestEntity);
    } catch (Exception e) {
      // Assume rn100 doesn’t exist, will fallback to the default message
      throw new BusinessException("rn100", Error.ERROR_WHEN_UPDATING_EXCEPTION.getMessage());
    }
  }

  @Getter
  private enum Error {
    ERROR_WHEN_UPDATING_EXCEPTION("Erro ao tentar atualizar a exceção");

    private final String message;

    Error(String message) {
      this.message = message;
    }
  }
}
