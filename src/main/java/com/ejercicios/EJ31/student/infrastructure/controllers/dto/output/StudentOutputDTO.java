package com.ejercicios.EJ31.student.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import lombok.Data;

@Data
public class StudentOutputDTO {

    private Integer id;
    private Integer idPerson;
    private int numHours;
    private String coments;
    private String branch;

    public StudentOutputDTO (StudentEntity studentEntity){
        setId(studentEntity.getId());
        setIdPerson(studentEntity.getIdPerson());
        setNumHours(studentEntity.getNumHours());
        setComents(studentEntity.getComents());
        setBranch(studentEntity.getBranch());
    }
}
