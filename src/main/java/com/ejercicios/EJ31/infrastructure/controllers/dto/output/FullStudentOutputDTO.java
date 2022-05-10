package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.domain.entities.SchoolSubjetEntity;
import com.ejercicios.EJ31.domain.entities.StudentEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FullStudentOutputDTO {

    private Integer id;
    private PersonEntity person;
    private int numHours;
    private String coments;
    private String branch;
    private List<SchoolSubjetEntity> subjets = new ArrayList<>();

    public FullStudentOutputDTO (StudentEntity studentEntity){
        setId(studentEntity.getId());
        setPerson(studentEntity.getPersonEntity());
        setNumHours(studentEntity.getNumHours());
        setComents(studentEntity.getComents());
        setBranch(studentEntity.getBranch());
        for(int i =0; i<studentEntity.getSubjetList().size(); i++){
            subjets.add(studentEntity.getSubjetList().get(i));
        }
    }
}
