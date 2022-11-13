package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.MailProps;


@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private MailProps mailProps;

    @GetMapping("")
    public String hello() {
        System.out.println(mailProps);

        return "boo";
    }

}
