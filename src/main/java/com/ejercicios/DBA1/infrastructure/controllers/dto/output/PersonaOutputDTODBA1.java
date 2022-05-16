package com.ejercicios.DBA1.infrastructure.controllers.dto.output;

import com.ejercicios.DBA1.domain.entities.PersonaDBA1;
import lombok.Data;

import java.time.LocalDate;

/*??????
    El output no lo hago de tipo record porque necesito el constructor
????*/

//Los DTO no hacerlos serializables
@Data
public class PersonaOutputDTODBA1 {

    private int id;
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

    public PersonaOutputDTODBA1(PersonaDBA1 personaEntity){//Constructos que recibe entity y lo convierte en outputDTO
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
