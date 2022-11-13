package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("home")
@PropertySource("classpath:custom.properties")
public class HomeController {

    @Value("${mail.from}")
    private String from;

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Value("${message}")
    private String message;

    @GetMapping("")
    public String hello() {
        System.out.println(from);
        System.out.println(host);
        System.out.println(port);
        System.out.println(message);

        return "boo";
    }

}
