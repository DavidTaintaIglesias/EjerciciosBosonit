package com.ejercicios.DBA1.domain.entities;

import com.ejercicios.DBA1.infrastructure.controllers.dto.input.PersonaInputDTODBA1;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

//Hacer las entidades serializables
@Entity
@Table(name = "personDBA1")
@Component //Para poder hacer el @Autowired
@Data
@NoArgsConstructor
public class PersonaDBA1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonId")
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
    LocalDate date;

    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "creation_date")
    LocalDate creationDate;

    public PersonaDBA1(PersonaInputDTODBA1 personaDTO){
        //Al ser InputDTO una clase de tipo recod no hay get/set, tienen el propio nombre de la variable como metodo get
        city=personaDTO.city();
        active=personaDTO.active();
        companyEmail =personaDTO.companyEmail();
        imageUrl =personaDTO.imageUrl();
        name=personaDTO.name();
        password=personaDTO.password();
        date=personaDTO.date();
        personalEmail =personaDTO.personalEmail();
        surname=personaDTO.surname();
        creationDate =personaDTO.creationDate();
        user= personaDTO.user();
    }
}
