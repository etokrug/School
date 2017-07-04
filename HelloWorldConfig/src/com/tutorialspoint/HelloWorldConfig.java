package com.tutorialspoint;
import org.springframework.context.annotation.*;

/**
 * Created by William on 7/2/2017.
 */

@Configuration
public class HelloWorldConfig {
    @Bean
    public HelloWorld hellowWorld(){
        return new HelloWorld();
    }
}
