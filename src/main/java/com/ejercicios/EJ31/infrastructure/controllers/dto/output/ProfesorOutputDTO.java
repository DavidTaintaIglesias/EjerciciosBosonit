package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.ProfesorEntity;
import lombok.Data;

@Data
public class ProfesorOutputDTO {

    private Integer id;
    private Integer idPerson;
    private String coments;
    private String branch;

    public ProfesorOutputDTO (ProfesorEntity profesorEntity){
        setId(profesorEntity.getId());
        setIdPerson(profesorEntity.getPersonEntity().getId());
        setComents(profesorEntity.getComents());
        setBranch(profesorEntity.getBranch());
    }
}
