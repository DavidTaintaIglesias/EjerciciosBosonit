package com.ejercicios.EJS31.infrastructure.controllers.dto.output;

import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentOutputDTOEJS31 {

    private Integer id;
    private Integer idPerson;
    private int numHours;
    private String coments;
    private Integer idProfesor;
    private String branch;

    public StudentOutputDTOEJS31(StudentEJS31 student){
        setId(student.getId());
        setIdPerson(student.getPerson().getId());
        setNumHours(student.getNumHours());
        setComents(student.getComents());
        setIdProfesor(student.getProfesor().getId());
        setBranch(student.getBranch());
    }
}
