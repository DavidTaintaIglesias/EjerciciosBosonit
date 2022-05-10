package com.ejercicios.EJ31.domain.entities;

import com.ejercicios.EJ31.infrastructure.controllers.dto.input.SchoolSubjetInputDTO;
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

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    StudentEntity studentEntity;
    */

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
