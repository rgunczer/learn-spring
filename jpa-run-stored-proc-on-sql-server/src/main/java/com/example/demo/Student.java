package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;

import lombok.Data;


@Entity
@Data
@NamedStoredProcedureQuery(
    name = "foo",
    procedureName = "uspGetStudentsBornIn",
    resultClasses = { Student.class },
    parameters={
        @StoredProcedureParameter(name="Dob", type=Integer.class, mode=ParameterMode.IN)
    }
)
public class Student {

    @Id
    private Long id;
    private String name;
    private int dob;

}
