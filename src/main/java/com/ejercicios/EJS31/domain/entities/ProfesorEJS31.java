package com.ejercicios.EJS31.domain.entities;

import com.ejercicios.EJS31.infrastructure.controllers.dto.input.ProfesorInputDTOEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profesorsEJS31")
@Data
@NoArgsConstructor
public class ProfesorEJS31 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    Integer id;

    @OneToOne
    @JoinColumn(name = "id_person")
    PersonEJS31 person;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    public ProfesorEJS31(ProfesorInputDTOEJS31 profesorInputDTO){
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }

    public void addPerson(PersonEJS31 person){
        setPerson(person);
    }
}
