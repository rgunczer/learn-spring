package com.example.demo.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProductionDatasourceConfig implements DatasourceConfig {

    public ProductionDatasourceConfig() {
        System.out.println("ProductionDatasourceConfig -> ctor");
    }

    @Override
    public void setup() {
        System.out.println("ProductionDatasourceConfig -> setup");
    }

}
