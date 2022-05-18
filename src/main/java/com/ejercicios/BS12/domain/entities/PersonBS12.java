package com.ejercicios.BS12.domain.entities;

import com.ejercicios.BS12.infrastructure.controllers.dto.input.PersonInputDTOBS12;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "PersonsBS12")
@Data
@NoArgsConstructor
public class PersonBS12 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_person")
    Integer id;

    @Column(name = "user")
    String usuario;

    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "company_email")
    String company_email;

    @Column(name = "personal_email")
    String personal_email;

    @Column(name = "city")
    String city;

    @Column(name = "active")
    boolean active;

    @Column(name = "created_date")
    LocalDate created_date;

    @Column(name = "imagen_url")
    String image_url;

    @Column(name = "creationDate")
    LocalDate termination_date;

    public PersonBS12(PersonInputDTOBS12 personInputDTO){
        setUsuario(personInputDTO.getUsuario());
        setPassword(personInputDTO.getPassword());
        setName(personInputDTO.getName());
        setSurname(personInputDTO.getSurname());
        setCompany_email(personInputDTO.getCompany_email());
        setPersonal_email(personInputDTO.getPersonal_email());
        setCity(personInputDTO.getCity());
        setActive(personInputDTO.isActive());
        setCreated_date(personInputDTO.getCreated_date());
        setImage_url(personInputDTO.getImage_url());
        setTermination_date(personInputDTO.getTermination_date());
    }
}
