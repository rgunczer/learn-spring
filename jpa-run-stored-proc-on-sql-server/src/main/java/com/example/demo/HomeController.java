package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    StudentRepository repo;

    @Autowired
    StudentService svc;


    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        var students = repo.findAll();

        return ResponseEntity.ok(students);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<?> getAllBornInYear(@PathVariable("year") Integer year) {
        var students = svc.get(year);

        return ResponseEntity.ok(students);
    }

}
