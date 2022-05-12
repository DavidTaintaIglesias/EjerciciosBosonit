package com.ejercicios.BS8.infrastructure.controllers.dto.input;

import lombok.Data;

import java.util.Date;

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
  private Date date;
  private String imageUrl;
  private Date terminationDate;


}
