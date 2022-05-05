package com.ejercicios.EJ31.student.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import lombok.Data;

@Data
public class StudentOutputDTO {

    private Integer id;
    private Integer idPersona;
    private int numHours;
    private String coments;

    public StudentOutputDTO (StudentEntity studentEntity){
        setId(studentEntity.getId());
        setIdPersona(studentEntity.getPersona().getId());
        setNumHours(studentEntity.getNumHours());
        setComents(studentEntity.getComents());
    }
}
