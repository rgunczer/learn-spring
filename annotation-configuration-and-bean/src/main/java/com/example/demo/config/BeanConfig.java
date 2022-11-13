package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.TestBean;

@Configuration
public class BeanConfig {

    public BeanConfig() {
        System.out.println("BeanConfig -> ctor");
    }

    @Bean
    public TestBean testBean() {
        System.out.println("testBean @Bean");
        return new TestBean();
    }
}
