package com.ejercicios.EJ31.schoolsubjet.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "student_schoolSubjet")
@Data
@NoArgsConstructor
public class SchoolSubjet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subjet")
    Integer id;

    @Column(name = "id_student")
    Integer idStudent;

    @Column(name = "name")
    String subjetName;

    @Column(name = "initial_date")
    Date initialDate;

    @Column(name = "finish_date")
    Date finishDate;
}
