package com.flan.envars.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
@ConfigurationProperties("some")
@Configuration
public class SomeConfigs {

    private String someValue;
    private List<String> someList;


    @PostConstruct
    public void setup() {
        log.info("SOME_VALUE [" + someValue + "]");
        log.info("SOME_LIST [" + someList + "]");
    }

}
