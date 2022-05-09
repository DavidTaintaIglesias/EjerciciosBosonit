package com.ejercicios.EJ31.domain.entities;

import com.ejercicios.EJ31.infrastructure.controllers.dto.input.ProfesorInputDTO;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person")
    PersonEntity personEntity;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    public ProfesorEntity (ProfesorInputDTO profesorInputDTO){
        setComents(profesorInputDTO.getComents());
        setBranch(profesorInputDTO.getBranch());
    }
}
