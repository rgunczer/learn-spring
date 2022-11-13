package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class EagerLoadingBean {

    public EagerLoadingBean() {
        System.out.println("EagerLoadingBean -> ctor");
    }

}
