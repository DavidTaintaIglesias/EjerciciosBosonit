package com.ejercicios.EJ31.student.infrastructure.controllers.dto.input;

import lombok.Data;

@Data
public class StudentInputDTO {

    private Integer idPerson;
    private int numHours;
    private String coments;
    private String branch;
}
