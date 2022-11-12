package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BaseDemoService;



@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    // @Qualifier("demoServiceImpl2") // specify which concrete implemantation is needed (to be injected)
    // the downside of this approach could be that this has to be specified in each place
    // another option is to use @Primary annotation in one of the implementation
    private BaseDemoService demoService;

    @GetMapping("")
    public String hello() {
        demoService.say();

        return "boo";
    }

}
