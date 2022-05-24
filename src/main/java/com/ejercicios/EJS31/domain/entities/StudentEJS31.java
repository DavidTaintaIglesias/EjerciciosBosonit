package com.ejercicios.EJS31.domain.entities;

import com.ejercicios.EJS31.infrastructure.controllers.dto.input.StudentInputDTOEJS31;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class StudentEJS31 implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_student")
    Integer id;

    @OneToOne
    @JoinColumn(name = "id_person")
    PersonEJS31 person;

    @Column(name = "num_hours_week")
    int numHours;

    @Column(name = "coments")
    String coments;

    @OneToOne
    @JoinColumn(name = "id_profesor")
    ProfesorEJS31 profesor;

    @Column(name = "branch")
    String branch;

    @OneToMany
    List<SubjetEJS31> subjets;

    public StudentEJS31(StudentInputDTOEJS31 studentInputDTO){
        setNumHours(studentInputDTO.getNumHours());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
    }

    public void addSubjet(SubjetEJS31 subjet){
        subjets.add(subjet);
    }

    public void removeSubjet(SubjetEJS31 subjet){
        subjets.remove(subjet);
    }

    public void addProfesor(ProfesorEJS31 profesor){
        setProfesor(profesor);
    }

    public void addPerson(PersonEJS31 person){
        setPerson(person);
    }
}
