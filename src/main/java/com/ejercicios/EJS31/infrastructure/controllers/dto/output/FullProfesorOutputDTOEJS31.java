package com.ejercicios.EJS31.infrastructure.controllers.dto.output;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FullProfesorOutputDTOEJS31 {
    private Integer id;
    private PersonEJS31 person;
    private String coments;
    private String branch;

    public FullProfesorOutputDTOEJS31(ProfesorEJS31 profesor){
        setId(profesor.getId());
        setPerson(profesor.getPerson());
        setComents(profesor.getComents());
        setBranch(profesor.getBranch());
    }
}
