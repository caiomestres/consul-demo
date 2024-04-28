package com.example.demo.ConsulStuff;

import com.example.demo.ConsulConfig;
import com.example.demo.ErrorStuff.ExceptionMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup {

    @Autowired
    private ConsulConfig consulConfig;

    @EventListener(ApplicationReadyEvent.class)
    public void initializeMessageUtil() {
        ExceptionMessageUtil.setConsulConfig(consulConfig);
    }
}
