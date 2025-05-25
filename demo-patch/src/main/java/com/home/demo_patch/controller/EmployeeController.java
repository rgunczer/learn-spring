package com.home.demo_patch.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.demo_patch.domain.Employee;


@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private ObjectMapper objectMapper;

    private List<Employee> employees = List.of(
        new Employee(1L, "First-1", "Last-1"),
        new Employee(2L, "First-2", "Last-2"),
        new Employee(3L, "First-3", "Last-3")
    );

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @PatchMapping("/{eid}")
    public Employee patchEmployee(
        @PathVariable Long eid,
        @RequestBody Map<String, Object> payload
    ) {
        final var emp = findById(eid);
        if (emp == null) {
            throw new RuntimeException("Employee with id [" + eid + "] NOT found");
        }

        return null;
    }

    // ------------------------------------------
    // utils

    public Employee findById(Long id) {
        return employees.stream()
            .filter(e -> e.id.equals(id))
            .findFirst()
            .orElse(null);
    }

}
