package com.example.demo.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        var dt = LocalDateTime.now();
        var df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Practice fast bowling for 15 minutes!? [" + dt.format(df) + "]";
    }

}
