package com.tutorialspoint;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by William on 7/2/2017.
 */
public class MainApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // Start an event
        context.start();

        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();

        // Stop an event
        context.stop();
    }
}
