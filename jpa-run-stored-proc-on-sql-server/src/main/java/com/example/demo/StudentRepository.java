package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(
        value = "EXEC dbo.uspGetStudentsBornIn @Dob = :Dob",
        nativeQuery = true
    )
    List<Student> getStudentsBornInAlt(@Param("Dob") Integer dob);

    @Procedure(name = "foo")
    List<Student> getStudentsBornIn(@Param("Dob") Integer dob);

}
