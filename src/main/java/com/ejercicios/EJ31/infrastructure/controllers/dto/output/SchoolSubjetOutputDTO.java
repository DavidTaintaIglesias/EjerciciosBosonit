package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.SchoolSubjetEntity;
import lombok.Data;

import java.util.Date;

@Data
public class SchoolSubjetOutputDTO {

    private Integer id;
    private String subjetName;
    private String coments;
    private Date initialDate;
    private Date finishDate;

    public SchoolSubjetOutputDTO(SchoolSubjetEntity schoolSubjetEntity){
        setId(schoolSubjetEntity.getId());
        setSubjetName(schoolSubjetEntity.getSubjetName());
        setComents(schoolSubjetEntity.getComents());
        setInitialDate(schoolSubjetEntity.getInitialDate());
        setFinishDate(schoolSubjetEntity.getFinishDate());
    }
}
