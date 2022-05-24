package com.ejercicios.EJS31.infrastructure.controllers.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class SubjetInputDTOEJS31 {

    private String name;
    private String coments;

    @NotNull
    private LocalDate initialDate;

    private LocalDate finishDate;
}
