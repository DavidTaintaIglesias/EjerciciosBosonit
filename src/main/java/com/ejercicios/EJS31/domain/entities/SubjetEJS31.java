package com.ejercicios.EJS31.domain.entities;

import com.ejercicios.EJS31.infrastructure.controllers.dto.input.SubjetInputDTOEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "subjets")
@Data
@NoArgsConstructor
public class SubjetEJS31 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_subjet")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "coments")
    String coments;


    @Column(name = "initial_date")
    LocalDate initialDate;

    @Column(name = "finish_date")
    LocalDate finishDate;

    public SubjetEJS31(SubjetInputDTOEJS31 subjetInputDTO){
        setName(subjetInputDTO.getName());
        setComents(subjetInputDTO.getComents());
        setInitialDate(subjetInputDTO.getInitialDate());
        setFinishDate(subjetInputDTO.getFinishDate());
    }
}
