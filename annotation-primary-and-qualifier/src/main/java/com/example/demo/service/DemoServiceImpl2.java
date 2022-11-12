package com.example.demo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DemoServiceImpl2 implements BaseDemoService {

    @Override
    public void say() {
        System.out.println("DemoServiceImpl2");
    }

}
