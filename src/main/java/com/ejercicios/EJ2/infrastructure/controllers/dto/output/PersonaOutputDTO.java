package com.ejercicios.EJ2.infrastructure.controllers.dto.output;

import com.ejercicios.EJ2.domain.Persona;
import lombok.Data;

import java.util.Date;

//Los DTO no hacerlos serializables
@Data
public class PersonaOutputDTO {

    private int id;
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

    public PersonaOutputDTO (Persona personaEntity){//Constructos que recibe entity y lo convierte en outputDTO
        id=(personaEntity.getId());
        user=(personaEntity.getUser());
        password=(personaEntity.getPassword());
        name=(personaEntity.getName());
        surname=(personaEntity.getSurname());
        companyEmail=(personaEntity.getCompanyEmail());
        personalEmail=(personaEntity.getPersonalEmail());
        city=(personaEntity.getCity());
        active=(personaEntity.getActive());
        date=(personaEntity.getDate());
        imageUrl=(personaEntity.getImageUrl());
        termination_date=(personaEntity.getTerminationDate());
    }
}
