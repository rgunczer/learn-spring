package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.service.ReportCreator;

@SpringBootApplication
public class DemoApplication {

    @Bean
    // @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    @RequestScope
    public ReportCreator reportCreator() {
        System.out.println("reportCreator @Bean @ReqestScope");
        return new ReportCreator();
    }


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
