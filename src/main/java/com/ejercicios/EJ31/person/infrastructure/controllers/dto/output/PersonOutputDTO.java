package com.ejercicios.EJ31.person.infrastructure.controllers.dto.output;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import lombok.Data;

import java.util.Date;

@Data
public class PersonOutputDTO {

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
    private Integer idProfesor;
    private Integer idStudent;

    public PersonOutputDTO(PersonEntity personaEntity){//Constructos que recibe entity y lo convierte en outputDTO
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
        if(personaEntity.getProfesorEntity()!=null){
            idProfesor=personaEntity.getProfesorEntity().getId();
        }
        if(personaEntity.getStudentEntity()!=null){
            idStudent = personaEntity.getStudentEntity().getId();
        }

    }
}
