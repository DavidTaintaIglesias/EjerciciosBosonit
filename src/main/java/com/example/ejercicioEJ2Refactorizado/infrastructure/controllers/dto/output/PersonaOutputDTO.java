package com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.output;

import com.example.ejercicioEJ2Refactorizado.domain.PersonaEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonaOutputDTO implements Serializable {

    private int id;
    private String user;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date date;
    private String image_url;
    private Date termination_date;

    public PersonaOutputDTO (PersonaEntity personaEntity){//Constructos que recibe entity y lo convierte en outputDTO
        id=(personaEntity.getId());
        user=(personaEntity.getUser());
        password=(personaEntity.getPassword());
        name=(personaEntity.getName());
        surname=(personaEntity.getSurname());
        company_email=(personaEntity.getCompany_email());
        personal_email=(personaEntity.getPersonal_email());
        city=(personaEntity.getCity());
        active=(personaEntity.getActive());
        date=(personaEntity.getDate());
        image_url=(personaEntity.getImage_url());
        termination_date=(personaEntity.getTermination_date());
    }
}
