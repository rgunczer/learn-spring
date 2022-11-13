package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ReportCreator;


@RestController
@RequestMapping("home")
// @Scope("singleton") // <-- default scope
// @Scope("prototype")
public class HomeController {

    @Autowired
    ReportCreator reportCreator;

    public HomeController() {
        System.out.println("HomeController -> ctor");
    }

    @GetMapping("")
    public String hello() {
        reportCreator.generate();

        return "boo";
    }

}
