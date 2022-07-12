package com.belyaeva;


import com.belyaeva.service.Demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //ctrl alt v
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        //context.getBean(Demo.class).authorDemo();
    }
}