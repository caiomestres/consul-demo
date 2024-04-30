package com.example.demo.ErrorStuff;

import com.example.demo.ConsulConfig;

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
        if (consulConfig == null || consulConfig.getAbacaxi() == null) {
            System.err.println("ConsulConfig is not initialized or does not contain any properties.");
            return defaultMessage;
        }

        ConsulConfig.ExceptionDetail message = consulConfig.getAbacaxi().get(identifier);
        if (message != null && message.getMessage() != null && !message.getMessage().isEmpty()) {
            return message.getMessage();
        } else {
            return defaultMessage;
        }

    }

    public static Integer getExceptionDetails(String identifier) {
        return consulConfig != null ? consulConfig.getAbacaxi().get(identifier).getStatusCode() : null;
    }
}
