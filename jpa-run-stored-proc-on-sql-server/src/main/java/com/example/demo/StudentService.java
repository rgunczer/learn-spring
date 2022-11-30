package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    @Transactional
    public List<Student> get(Integer year) {

        var lst = repo.getStudentsBornIn(year);
        return lst;
    }

}
