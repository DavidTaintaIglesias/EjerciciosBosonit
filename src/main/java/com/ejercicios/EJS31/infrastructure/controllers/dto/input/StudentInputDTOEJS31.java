package com.ejercicios.EJS31.infrastructure.controllers.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class StudentInputDTOEJS31 {

    private Integer idPerson;

    @NotNull(message = "number of hours cannot be null")
    private Integer numHours;

    private String coments;

    private Integer idProfesor;

    @NotNull(message = "branch cannot be null")
    private String branch;
}
