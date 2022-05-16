package com.ejercicios.JVA2.infrastructure.controllers.dto.output;

import com.ejercicios.JVA2.domain.entities.PersonaJVA2;
import lombok.Data;

import java.util.Date;

//Los DTO no hacerlos serializables
@Data
public class PersonaOutputDTOJVA2 {

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

    public PersonaOutputDTOJVA2(PersonaJVA2 personaEntity){//Constructos que recibe entity y lo convierte en outputDTO
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
