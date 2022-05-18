package com.ejercicios.EJ31.domain.entities;

import com.ejercicios.EJ31.infrastructure.controllers.dto.input.ProfesorInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "profesors")
@Data
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_profesor")
    Integer id;

    @OneToOne
    @JoinColumn(name = "id_person")
    Person person;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    public Profesor(ProfesorInputDTO profesorInputDTO){
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }

    public void addPerson(Person person){
        setPerson(person);
    }
}
