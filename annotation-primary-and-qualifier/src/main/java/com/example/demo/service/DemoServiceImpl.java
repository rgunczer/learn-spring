package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements BaseDemoService {

    @Override
    public void say() {
        System.out.println("DemoServiceImpl");
    }

}
