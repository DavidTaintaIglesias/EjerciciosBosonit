package com.ejercicios.BS8.domain.entities;


import com.ejercicios.BS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Component //Para poder hacer el @Autowired
@Data
@NoArgsConstructor
public class PersonaEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "persona_id")
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

    public PersonaEntity(PersonaInputDTO personaDTO){//Creo un costructor que recibe personaDTO
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