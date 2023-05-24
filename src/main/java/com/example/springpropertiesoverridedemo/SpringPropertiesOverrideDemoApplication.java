package com.example.springpropertiesoverridedemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringPropertiesOverrideDemoApplication {

    private final ApplicationContext context;

    public SpringPropertiesOverrideDemoApplication(ApplicationContext context,
                                                   @Value("${demo.example1:#{null}}") String prop1,
                                                   @Value("${demo.example2:#{null}}") String prop2,
                                                   @Value("${demo.example3:#{null}}") String prop3) {
        this.context = context;
        System.out.printf("demo.example1=%s%n", prop1);
        System.out.printf("demo.example2=%s%n", prop2);
        System.out.printf("demo.example3=%s%n", prop3);
    }


    @PostConstruct
    void init() {
        // System.exit(0) causes a dead-lock in spring without explicit context exit
        System.exit(SpringApplication.exit(context, () -> 0));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesOverrideDemoApplication.class, args);
    }

}
