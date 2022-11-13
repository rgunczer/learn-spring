package com.example.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ExtendedReportCreator {

    public ExtendedReportCreator() {
        System.out.println("ReportCreator -> ctor");
    }

    public void generate() {
        System.out.println("ExtendedReportCreator -> generate");
    }
}
