package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.DatasourceConfig;
import com.example.demo.etc.ProfileManager;


@RestController
@RequestMapping("home")
public class HomeController {

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Autowired
    ProfileManager profileManager;

    @Autowired
    DatasourceConfig datasourceConfig;

    @GetMapping("")
    public String hello() {
        profileManager.dumpActiveProfiles();
        datasourceConfig.setup();
        System.out.println("active profile(s) is [" + activeProfile + "]");

        return "boo";
    }

}
