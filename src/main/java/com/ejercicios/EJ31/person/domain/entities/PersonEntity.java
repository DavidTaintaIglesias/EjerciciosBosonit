package com.ejercicios.EJ31.person.domain.entities;

import com.ejercicios.EJ31.person.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.profesor.domain.entities.ProfesorEntity;
import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
public class PersonEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    Integer id;

    @NotNull
    @Column(name = "user")
    String user;

    @NotNull
    @Column(name = "password")
    String password;

    //@Column("nombre de la columna")
    @NotNull
    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @NotNull
    @Column(name = "companyEmail")
    String companyEmail;

    @NotNull
    @Column(name = "personalEmail")
    String personalEmail;

    @NotNull
    @Column(name = "city")
    String city;

    @NotNull
    @Column(name = "active")
    Boolean active;

    @NotNull
    @Column(name = "date")
    Date date;

    @Column(name = "imageUrl")
    String imageUrl;
    @Column(name = "terminationDate")
    Date terminationDate;

    @OneToOne
    @JoinColumn(name = "id_student")
    StudentEntity studentEntity;

    @OneToOne
    @JoinColumn(name = "id_profesor")
    ProfesorEntity profesorEntity;


    public PersonEntity(PersonInputDTO personaDTO){//Creo un costructor que recibe personaDTO
        //Como id es autoincrementable no pongo ningun set para el ya que se añadirá solo
        city=personaDTO.getCity();
        active=personaDTO.getActive();
        companyEmail =personaDTO.getCompanyEmail();
        imageUrl =personaDTO.getImageUrl();
        name=personaDTO.getName();
        password=personaDTO.getPassword();
        date=personaDTO.getDate();
        personalEmail =personaDTO.getPersonalEmail();
        surname=personaDTO.getSurname();
        terminationDate =personaDTO.getTerminationDate();
        user= personaDTO.getUser();
    }
}
