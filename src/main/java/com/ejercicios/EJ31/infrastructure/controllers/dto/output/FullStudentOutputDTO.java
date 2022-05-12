package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.Person;
import com.ejercicios.EJ31.domain.entities.Profesor;
import com.ejercicios.EJ31.domain.entities.Student;
import com.ejercicios.EJ31.domain.entities.Subjet;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FullStudentOutputDTO {

    private Integer id;
    private Person person;
    private int numHours;
    private String coments;
    private Profesor profesor;
    private String branch;
    private List<Subjet> subjets;

    public FullStudentOutputDTO(Student student){
        setId(student.getId());
        setPerson(student.getPerson());
        setNumHours(student.getNumHours());
        setComents(student.getComents());
        setProfesor(student.getProfesor());
        setBranch(student.getBranch());
        setSubjets(student.getSubjets());
    }
}
