package com.ejercicios.EJ31.infrastructure.controllers.dto.input;

import lombok.Data;

@Data
public class ProfesorInputDTO {

    private Integer id;
    private Integer idPerson;
    private String coments;
    private String branch;
}