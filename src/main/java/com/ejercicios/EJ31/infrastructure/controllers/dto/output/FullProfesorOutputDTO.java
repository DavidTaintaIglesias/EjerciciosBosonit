package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.Person;
import com.ejercicios.EJ31.domain.entities.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FullProfesorOutputDTO {
    private Integer id;
    private Person person;
    private String coments;
    private String branch;

    public FullProfesorOutputDTO(Profesor profesor){
        setId(profesor.getId());
        setPerson(profesor.getPerson());
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }
}
