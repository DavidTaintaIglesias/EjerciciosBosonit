package com.ejercicios.JVA2.infrastructure.controllers.dto.input;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaInputDTOJVA2 {


    private String user;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private Date date;
    private String imageUrl;
    private Date termination_date;


}
