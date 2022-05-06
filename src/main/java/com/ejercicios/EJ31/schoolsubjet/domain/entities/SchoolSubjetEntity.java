package com.ejercicios.EJ31.schoolsubjet.domain.entities;

import com.ejercicios.EJ31.schoolsubjet.infrastructure.controllers.dto.input.SchoolSubjetInputDTO;
import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student_schoolsubjet")
@Data
@NoArgsConstructor
public class SchoolSubjetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subjet")
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    StudentEntity studentEntity;

    @Column(name = "name")
    String subjetName;

    @Column(name = "coments")
    String coments;

    @Column(name = "initial_date")
    Date initialDate;

    @Column(name = "finish_date")
    Date finishDate;

    public SchoolSubjetEntity(SchoolSubjetInputDTO schoolSubjetInputDTO){
        setSubjetName(schoolSubjetInputDTO.getSubjetName());
        setComents(schoolSubjetInputDTO.getComents());
        setInitialDate(schoolSubjetInputDTO.getInitialDate());
        setFinishDate(schoolSubjetInputDTO.getFinishDate());
    }
}
