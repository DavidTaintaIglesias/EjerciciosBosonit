package com.ejercicios.EJS31.infrastructure.controllers.dto.output;

import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfesorOutputDTOEJS31 {

    private Integer id;
    private Integer idPerson;
    private String coments;
    private String branch;

    public ProfesorOutputDTOEJS31(ProfesorEJS31 profesor){
        setId(profesor.getId());
        setIdPerson(profesor.getPerson().getId());
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }
}
