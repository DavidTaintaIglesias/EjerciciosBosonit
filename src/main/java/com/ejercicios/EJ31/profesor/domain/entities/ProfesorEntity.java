package com.ejercicios.EJ31.profesor.domain.entities;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.profesor.infrastructure.controllers.dto.input.ProfesorInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesor")
@Data
@NoArgsConstructor
public class ProfesorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "id_person")
    Integer idPerson;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    public ProfesorEntity (ProfesorInputDTO profesorInputDTO){
        setIdPerson(profesorInputDTO.getIdPerson());
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }
}
