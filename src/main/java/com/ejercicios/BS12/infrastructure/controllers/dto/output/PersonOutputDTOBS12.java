package com.ejercicios.BS12.infrastructure.controllers.dto.output;

import com.ejercicios.BS12.domain.entities.PersonBS12;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonOutputDTOBS12 {

  private Integer id;
  private String usuario;
  private String name;
  private String surname;
  private String company_email;
  private String personal_email;
  private String city;
  private boolean active;
  private LocalDate created_date;
  private String image_url;
  private LocalDate termination_date;

  public PersonOutputDTOBS12(PersonBS12 person) {

    setId(person.getId());
    setUsuario(person.getUsuario());
    setName(person.getName());
    setSurname(person.getSurname());
    setCompany_email(person.getCompany_email());
    setPersonal_email(person.getPersonal_email());
    setCity(person.getCity());
    setActive(person.isActive());
    setCreated_date(person.getCreated_date());
    setImage_url(person.getImage_url());
    setTermination_date(person.getTermination_date());
  }

}
