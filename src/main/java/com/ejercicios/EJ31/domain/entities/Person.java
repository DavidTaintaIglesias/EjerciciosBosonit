package com.ejercicios.EJ31.domain.entities;

import com.ejercicios.EJ31.infrastructure.controllers.dto.input.PersonInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Persons")
@Data
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    Integer id;

    @Column(name = "user")
    String user;

    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "company_email")
    String companyEmail;

    @Column(name = "personal_email")
    String personalEmail;

    @Column(name = "city")
    String city;

    @Column(name = "active")
    boolean active;

    @Column(name = "created_date")
    LocalDate createdDate;

    @Column(name = "imagen_url")
    String imageUrl;

    @Column(name = "creationDate")
    LocalDate terminationDate;

    @Column(name = "id_student")
    Integer idStudent;

    @Column(name = "id_profesor")
    Integer idProfesor;

    public Person(PersonInputDTO personInputDTO){
        setUser(personInputDTO.getUser());
        setPassword(personInputDTO.getPassword());
        setName(personInputDTO.getName());
        setSurname(personInputDTO.getSurname());
        setCompanyEmail(personInputDTO.getCompanyEmail());
        setPersonalEmail(personInputDTO.getPersonalEmail());
        setCity(personInputDTO.getCity());
        setActive(personInputDTO.isActive());
        setCreatedDate(personInputDTO.getCreatedDate());
        setImageUrl(personInputDTO.getImageUrl());
        setTerminationDate(personInputDTO.getTerminationDate());
    }
}
