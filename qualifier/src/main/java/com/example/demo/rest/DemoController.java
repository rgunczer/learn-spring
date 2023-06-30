package com.example.demo.rest;

import com.example.demo.common.Coach;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

//    public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
    public DemoController(@Qualifier("trackCoach") Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyworkout() {
        return myCoach.getDailyWorkout();
    }

}
