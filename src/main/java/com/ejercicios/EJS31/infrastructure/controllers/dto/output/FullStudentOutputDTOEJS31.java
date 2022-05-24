package com.ejercicios.EJS31.infrastructure.controllers.dto.output;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.domain.entities.SubjetEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FullStudentOutputDTOEJS31 {

    private Integer id;
    private PersonEJS31 person;
    private int numHours;
    private String coments;
    private ProfesorEJS31 profesor;
    private String branch;
    private List<SubjetEJS31> subjets;

    public FullStudentOutputDTOEJS31(StudentEJS31 student){
        setId(student.getId());
        setPerson(student.getPerson());
        setNumHours(student.getNumHours());
        setComents(student.getComents());
        setProfesor(student.getProfesor());
        setBranch(student.getBranch());
        setSubjets(student.getSubjets());
    }
}
