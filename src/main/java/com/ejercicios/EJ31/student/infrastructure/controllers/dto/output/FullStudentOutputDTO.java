package com.ejercicios.EJ31.student.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import lombok.Data;

@Data
public class FullStudentOutputDTO {

    private Integer id;
    private PersonEntity person;
    private int numHours;
    private String coments;
    private String branch;

    public FullStudentOutputDTO (StudentEntity studentEntity){
        setId(studentEntity.getId());
        setPerson(studentEntity.getPersonEntity());
        setNumHours(studentEntity.getNumHours());
        setComents(studentEntity.getComents());
        setBranch(studentEntity.getBranch());
    }
}
