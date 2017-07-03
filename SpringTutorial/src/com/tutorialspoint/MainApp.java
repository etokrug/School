package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by William on 7/1/2017.
 */

// Stopped at dependency injection:
//    https://www.tutorialspoint.com/spring/spring_dependency_injection.htm
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
        objA.getMessage1();
        objA.getMessage2();

        HelloDatBoi objB = (HelloDatBoi) context.getBean("helloDatBoi");
        objB.getMessage1();
        objB.getMessage2();
        objB.getMessage3();


    }
}
