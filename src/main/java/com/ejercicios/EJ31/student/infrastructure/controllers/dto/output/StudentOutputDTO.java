package com.ejercicios.EJ31.student.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.schoolsubjet.domain.entities.SchoolSubjetEntity;
import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import lombok.Data;

import java.util.List;

@Data
public class StudentOutputDTO {

    private Integer id;
    private Integer idPerson;
    private int numHours;
    private String coments;
    private String branch;
    private List<Integer> subjets;

    public StudentOutputDTO (StudentEntity studentEntity){
        setId(studentEntity.getId());
        setIdPerson(studentEntity.getPersonEntity().getId());
        setNumHours(studentEntity.getNumHours());
        setComents(studentEntity.getComents());
        setBranch(studentEntity.getBranch());
        if(studentEntity.getSubjetList()!=null){
            for(int i=0; i<studentEntity.getSubjetList().size();i++){
                subjets.add(studentEntity.getSubjetList().get(1).getId());
            }
        }

    }
}
