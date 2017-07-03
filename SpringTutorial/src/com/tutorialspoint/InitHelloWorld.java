package com.tutorialspoint;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

/**
 * Created by William on 7/1/2017.
 */
public class InitHelloWorld implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        System.out.println("Before Initialization: " + beanName);
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String beanName)
        throws BeansException {
        System.out.println("After initialization: " + beanName);
        return bean;
    }
}
