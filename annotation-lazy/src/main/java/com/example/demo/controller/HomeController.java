package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LazyLoadingBean;


@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private LazyLoadingBean lazyLoadingBean; // <-- this is enough to createa a bean which is annotated as @Lazy

    @GetMapping("")
    public String hello() {

        return "boo";
    }

}
