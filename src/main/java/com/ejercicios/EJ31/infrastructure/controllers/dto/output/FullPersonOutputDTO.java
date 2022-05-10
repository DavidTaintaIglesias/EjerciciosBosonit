package com.ejercicios.EJ31.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.domain.entities.ProfesorEntity;
import com.ejercicios.EJ31.domain.entities.StudentEntity;
import lombok.Data;

import java.util.Date;

@Data
public class FullPersonOutputDTO {

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
    private Date terminationDate;
    private StudentEntity studentEntity;
    private ProfesorEntity profesorEntity;


    public FullPersonOutputDTO(PersonEntity personaEntity){//Constructor que recibe entity y lo convierte en outputDTO
        id=(personaEntity.getId());
        user=(personaEntity.getUser());
        password=(personaEntity.getPassword());
        name=(personaEntity.getName());
        surname=(personaEntity.getSurname());
        companyEmail =(personaEntity.getCompanyEmail());
        personalEmail =(personaEntity.getPersonalEmail());
        city=(personaEntity.getCity());
        active=(personaEntity.getActive());
        date=(personaEntity.getDate());
        imageUrl =(personaEntity.getImageUrl());
        terminationDate =(personaEntity.getTerminationDate());
    }
}
