package com.example.demo.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevDatasourceConfig implements DatasourceConfig {

    public DevDatasourceConfig() {
        System.out.println("DevDatasourceConfig -> ctor");
    }

    @Override
    public void setup() {
        System.out.println("DevDatasourceConfig -> setup");
    }

}
