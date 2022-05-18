package com.ejercicios.JVA2.domain.entities;

import com.ejercicios.JVA2.infrastructure.controllers.dto.input.PersonaInputDTOJVA2;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

//Hacer las entidades serializables
@Entity
@Component //Para poder hacer el @Autowired
@Data
@NoArgsConstructor
public class PersonaJVA2 {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    @Column(name = "imaage_url")
    String imageUrl;
    @Column(name = "creationDate")
    LocalDate terminationDate;

    public PersonaJVA2(PersonaInputDTOJVA2 personaDTO){
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
        terminationDate =personaDTO.termination_date();
        user= personaDTO.user();
    }
}
