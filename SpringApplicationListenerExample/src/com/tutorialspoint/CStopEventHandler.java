package com.tutorialspoint;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * Created by William on 7/2/2017.
 */
public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
    public void onApplicationEvent(ContextStoppedEvent event) {
        System.out.println("ContextStoppedEvent Received");
    }
}
