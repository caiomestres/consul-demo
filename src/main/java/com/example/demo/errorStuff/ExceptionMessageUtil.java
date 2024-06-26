package com.example.demo.errorStuff;

import com.example.demo.consulStuff.ConsulConfig;

public class ExceptionMessageUtil {

  private static ConsulConfig consulConfig; // Static reference to hold the Consul configuration

  /**
   * Initializes MessageUtil with the provided ConsulConfig.
   * This method should be called once during the application startup.
   *
   * @param config The ConsulConfig to use for fetching configuration messages.
   */
  public static void setConsulConfig(ConsulConfig config) {
    ExceptionMessageUtil.consulConfig = config;
  }

  public static String getMessage(String identifier, String defaultMessage) {
    if (consulConfig == null || consulConfig.getException() == null) {
      System.err.println("ConsulConfig is not initialized or does not contain any properties.");
      return defaultMessage;
    }

    String message = consulConfig.getException().get(identifier);
    if (message != null && !message.isEmpty()) {
      return message;
    } else {
      return defaultMessage;
    }

  }
}
