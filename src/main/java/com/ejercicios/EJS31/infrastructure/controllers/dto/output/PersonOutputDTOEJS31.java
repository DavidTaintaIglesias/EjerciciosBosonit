package com.ejercicios.EJS31.infrastructure.controllers.dto.output;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonOutputDTOEJS31 {

    private Integer id;
    private String user;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private LocalDate createdDate;
    private String imageUrl;
    private LocalDate terminationDate;

    public PersonOutputDTOEJS31(PersonEJS31 person){
        setId(person.getId());
        setUser(person.getUser());
        setName(person.getName());
        setSurname(person.getSurname());
        setCompanyEmail(person.getCompanyEmail());
        setPersonalEmail(person.getPersonalEmail());
        setCity(person.getCity());
        setActive(person.isActive());
        setCreatedDate(person.getCreatedDate());
        setImageUrl(person.getImageUrl());
        setTerminationDate(person.getTerminationDate());
    }
}
