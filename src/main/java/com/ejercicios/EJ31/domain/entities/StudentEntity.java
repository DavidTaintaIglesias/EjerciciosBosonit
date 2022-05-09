package com.ejercicios.EJ31.domain.entities;

import com.ejercicios.EJ31.infrastructure.controllers.dto.input.StudentInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class StudentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    Integer id;

    @OneToOne
    @JoinColumn(name = "id_person")
    PersonEntity personEntity;

    @Column(name = "num_hours_week")
    int numHours;

    @Column(name = "coments")
    String coments;

    @Column(name = "branch")
    String branch;

    @OneToMany
    List<SchoolSubjetEntity> subjetList = new ArrayList<>();

    public StudentEntity (StudentInputDTO studentInputDTO){
        setNumHours(studentInputDTO.getNumHours());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
    }

    public void addSubjet (SchoolSubjetEntity subjet){
        subjetList.add(subjet);
    }
}
