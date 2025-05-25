package com.home.demo_patch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Employee {

    public Long id;
    public String firstName;
    public String lastName;

}
