package com.ejercicios.EJ31.infrastructure.controllers.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProfesorInputDTO {

  private Integer idPerson;

  private String coments;

  @NotNull(message = "branch cannot be null")
  private String branch;

}
