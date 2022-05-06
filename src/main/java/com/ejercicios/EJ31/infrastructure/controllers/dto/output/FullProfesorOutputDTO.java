package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.domain.entities.ProfesorEntity;
import lombok.Data;

@Data
public class FullProfesorOutputDTO {

    private Integer id;
    private PersonEntity person;
    private String coments;
    private String branch;

    public FullProfesorOutputDTO (ProfesorEntity profesorEntity){
        setId(profesorEntity.getId());
        setPerson(profesorEntity.getPersonEntity());
        setComents(profesorEntity.getComents());
        setBranch(profesorEntity.getBranch());
    }
}
