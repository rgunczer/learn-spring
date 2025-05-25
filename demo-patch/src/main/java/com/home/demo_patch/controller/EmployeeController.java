package com.home.demo_patch.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.home.demo_patch.domain.Employee;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private final ObjectMapper objectMapper;

    private List<Employee> employees = new ArrayList<>(
        List.of(
            new Employee(1L, "First-1", "Last-1"),
            new Employee(2L, "First-2", "Last-2"),
            new Employee(3L, "First-3", "Last-3")
        )
    );


    @GetMapping
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @PatchMapping("/{eid}")
    public Employee patchEmployee(
        @PathVariable Long eid,
        @RequestBody Map<String, Object> payload
    ) throws BadRequestException {
        final var emp = findById(eid);
        if (emp == null) {
            throw new RuntimeException("Employee with id [" + eid + "] NOT found");
        }

        if (payload.containsKey("id")) {
            throw new BadRequestException("Employee id not allowed in request body [" + payload.get("id") + "]");
        }

        final var patchedEmp = apply(payload, emp);

        final var savedEmp = save(patchedEmp);

        return savedEmp;
    }

    // ------------------------------------------
    // utils

    private Employee findById(final Long id) {
        return employees.stream()
            .filter(e -> e.id.equals(id))
            .findFirst()
            .orElse(null);
    }

    private int findIndexById(final Long id) {
        return IntStream.range(0, employees.size())
            .filter(i -> employees.get(i).getId().equals(id))
            .findFirst()
            .orElse(-1);
    }

    private Employee apply(
        final Map<String, Object> payload,
        final Employee emp
    ) {
        // convert employee object to a JSON object node
        final var empNode = objectMapper.convertValue(emp, ObjectNode.class);

        // convert the patch-payload map to a JSON object node
        final var patchNode = objectMapper.convertValue(payload, ObjectNode.class);

        // "magic" -> merge the patch updates into the employee node
        empNode.setAll(patchNode);

        final var patchedEmp = objectMapper.convertValue(empNode, Employee.class);
        return patchedEmp;
    }

    // simulate DB layer's save method (EmployeeRepository)
    private Employee save(final Employee updatedEmp) {
        final var empDb = findById(updatedEmp.getId());
        final var empIndex = findIndexById(empDb.getId());

        employees.set(empIndex, updatedEmp);

        return updatedEmp;
    }

}
