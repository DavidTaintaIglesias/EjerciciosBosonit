package com.ejercicios.BS8.infrastructure.controllers.dto.output;

import com.ejercicios.BS8.domain.entities.PersonaEntity;
import lombok.Data;

import java.util.Date;

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
  private Date terminationDate;

  public PersonaOutputDTO(PersonaEntity personaEntity) {//Constructos que recibe entity y lo convierte en outputDTO
    id = (personaEntity.getId());
    user = (personaEntity.getUser());
    password = (personaEntity.getPassword());
    name = (personaEntity.getName());
    surname = (personaEntity.getSurname());
    companyEmail = (personaEntity.getCompanyEmail());
    personalEmail = (personaEntity.getPersonalEmail());
    city = (personaEntity.getCity());
    active = (personaEntity.getActive());
    date = (personaEntity.getDate());
    imageUrl = (personaEntity.getImageUrl());
    terminationDate = (personaEntity.getTerminationDate());
  }

}
