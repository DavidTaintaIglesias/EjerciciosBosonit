package com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.input;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonaInputDTO implements Serializable {


    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date date;
    private String image_url;
    private Date termination_date;


}
