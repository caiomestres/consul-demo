//package com.example.demo.ConsulStuff;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.context.event.EventListener;
//import org.springframework.cloud.client.discovery.event.InstanceRegisteredEvent;
//import org.springframework.cloud.context.refresh.ContextRefresher;
//import org.springframework.stereotype.Component;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//@Component
//public class ConsulReconnectionHandler {
//
//    private static final Logger log = LoggerFactory.getLogger(ConsulReconnectionHandler.class);
//
//    private final ApplicationEventPublisher publisher;
//    private final ContextRefresher contextRefresher;
//
//    public ConsulReconnectionHandler(ApplicationEventPublisher publisher,
//                                     @Qualifier("configDataContextRefresher") ContextRefresher contextRefresher) {
//        this.publisher = publisher;
//        this.contextRefresher = contextRefresher;
//        log.debug("ConsulReconnectionHandler initialized.");
//    }
//
//    @EventListener(InstanceRegisteredEvent.class)
//    public void onInstanceRegistered(InstanceRegisteredEvent<?> event) {
//        log.debug("InstanceRegisteredEvent received, triggering refresh.");
//        contextRefresher.refresh();
//        log.debug("Context refresh triggered.");
//    }
//}
