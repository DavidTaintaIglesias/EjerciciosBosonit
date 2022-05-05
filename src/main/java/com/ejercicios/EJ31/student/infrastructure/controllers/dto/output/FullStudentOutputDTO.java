package com.ejercicios.EJ31.student.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import lombok.Data;

@Data
public class FullStudentOutputDTO {

    private Integer id;
    private PersonEntity persona;
    private int numHours;
    private String coments;

    public FullStudentOutputDTO (StudentEntity studentEntity){
        setId(studentEntity.getId());
        setPersona(studentEntity.getPersona());
        setNumHours(studentEntity.getNumHours());
        setComents(studentEntity.getComents());
    }
}
