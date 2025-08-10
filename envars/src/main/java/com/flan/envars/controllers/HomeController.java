package com.flan.envars.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flan.envars.config.SomeConfigs;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/home")
@RestController
public class HomeController {

    private final SomeConfigs someConfigs;


    @GetMapping()
    public String hello() {
        return "HELLOOOO [" + someConfigs.getSomeValue() + "]";
    }

    @GetMapping("/list")
    public List<String> helloList() {
        return someConfigs.getSomeList();
    }

}
