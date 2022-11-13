package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.TestBean;

@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    TestBean testBean;

    @GetMapping("")
    public String hello() {
        testBean.saySomething();

        return "boo";
    }

}
