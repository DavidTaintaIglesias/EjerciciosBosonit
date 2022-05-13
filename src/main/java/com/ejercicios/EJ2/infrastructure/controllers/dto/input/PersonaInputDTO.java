package com.ejercicios.EJ2.infrastructure.controllers.dto.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class PersonaInputDTO {

  @NotBlank(message = "User no puede estar vacio")
  @NotNull(message = "User no puede estar vacio")
  @Size(min = 6, max = 10, message = "User debe estar entre 6 y 10 caracteres")
  private String user;

  private String password;
  private String name;
  private String surname;
  private String companyEmail;
  private String personalEmail;
  private String city;
  private Boolean active;
  private LocalDate date;
  private String imageUrl;
  private LocalDate terminationDate;

}
