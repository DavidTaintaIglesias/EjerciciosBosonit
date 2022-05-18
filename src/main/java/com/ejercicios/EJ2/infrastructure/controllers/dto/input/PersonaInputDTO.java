package com.ejercicios.EJ2.infrastructure.controllers.dto.input;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonaInputDTO {


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
    private LocalDate termination_date;


}
