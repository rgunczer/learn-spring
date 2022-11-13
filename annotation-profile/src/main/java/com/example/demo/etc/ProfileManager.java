package com.example.demo.etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class ProfileManager {

    @Autowired
    private Environment environment;

    public void dumpActiveProfiles() {
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println("Currently active profile - [" + profileName + "]");
        }
    }

}
