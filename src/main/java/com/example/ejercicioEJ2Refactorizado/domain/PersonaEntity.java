package com.example.ejercicioEJ2Refactorizado.domain;

import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Component //Para poder hacer el @Autowired
@Data
@NoArgsConstructor
public class PersonaEntity {

    @Id
    @GeneratedValue
    Integer id;

    @NotNull
    String user;

    @NotNull
    String password;

    //@Column("nombre de la columna")
    @NotNull
    String name;

    String surname;

    @NotNull
    String company_email;

    @NotNull
    String personal_email;

    @NotNull
    String city;

    @NotNull
    Boolean active;

    @NotNull
    Date date;

    String image_url;
    Date termination_date;

    public PersonaEntity(PersonaInputDTO personaDTO){//Creo un costructor que recibe personaDTO
        //Como id es autoincrementable no pongo ningun set para el ya que se añadirá solo
        city=personaDTO.getCity();
        active=personaDTO.getActive();
        company_email=personaDTO.getCompany_email();
        image_url=personaDTO.getImage_url();
        name=personaDTO.getName();
        password=personaDTO.getPassword();
        date=personaDTO.getDate();
        personal_email=personaDTO.getPersonal_email();
        surname=personaDTO.getSurname();
        termination_date=personaDTO.getTermination_date();
        user= personaDTO.getUser();
    }
}
