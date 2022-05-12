package com.ejercicios.EJ31.domain.entities;

import com.ejercicios.EJ31.infrastructure.controllers.dto.input.StudentInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    Integer id;

    @OneToOne
    @JoinColumn(name = "id_person")
    Person person;

    @Column(name = "num_hours_week")
    int numHours;

    @Column(name = "coments")
    String coments;

    @OneToOne
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @Column(name = "branch")
    String branch;

    @OneToMany
    List<Subjet> subjets;

    public Student(StudentInputDTO studentInputDTO){
        setNumHours(studentInputDTO.getNumHours());
        setComents(studentInputDTO.getComents());
        setBranch(studentInputDTO.getBranch());
    }

    public void addSubjet(Subjet subjet){
        subjets.add(subjet);
    }

    public void removeSubjet(Subjet subjet){
        subjets.remove(subjet);
    }

    public void addProfesor(Profesor profesor){
        setProfesor(profesor);
    }

    public void addPerson(Person person){
        setPerson(person);
    }
}
