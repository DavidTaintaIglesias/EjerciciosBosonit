package com.ejercicios.EJ31.infrastructure.controllers.dto.input;

import lombok.Data;
import java.util.Date;

 @Data
public class SchoolSubjetInputDTO {

    private Integer idStudent;
    private String subjetName;
    private String coments;
    private Date initialDate;
    private Date finishDate;
}
