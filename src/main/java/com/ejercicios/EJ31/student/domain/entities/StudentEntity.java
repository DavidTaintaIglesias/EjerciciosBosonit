package com.ejercicios.EJ31.student.domain.entities;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.student.infrastructure.controllers.dto.input.StudentInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class StudentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    Integer id;

    @Column(name = "id_person")
    Integer idPerson;

    @Column(name = "num_hours_week")
    int numHours;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    public StudentEntity (StudentInputDTO studentInputDTO){
        setIdPerson(studentInputDTO.getIdPerson());
        setNumHours(studentInputDTO.getNumHours());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
    }
}
