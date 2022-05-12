package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDTO {

    private Integer id;
    private Integer idPerson;
    private String coments;
    private String branch;

    public ProfesorOutputDTO(Profesor profesor){
        setId(profesor.getId());
        setIdPerson(profesor.getPerson().getId());
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }
}
