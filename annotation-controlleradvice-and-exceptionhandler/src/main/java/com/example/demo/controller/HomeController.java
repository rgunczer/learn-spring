package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.StudentNotFoundException;

@RestController
@RequestMapping("home")
public class HomeController {

    @GetMapping("/{id}")
    public String getHelloById(@PathVariable int id) throws StudentNotFoundException {
        System.out.println(id);

        if (id > 10) {
            throw new StudentNotFoundException("some error message for id [" + id + "]");
        }

        return "boo";
    }

}
