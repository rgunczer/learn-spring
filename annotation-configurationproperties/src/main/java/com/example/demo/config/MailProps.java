package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "mail")
@Component
public class MailProps {

    private String from;
    private String host;
    private String port;

}
