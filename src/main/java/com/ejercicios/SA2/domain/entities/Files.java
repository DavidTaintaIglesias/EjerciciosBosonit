package com.ejercicios.SA2.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "files_table")
@Setter
@Getter
@NoArgsConstructor
public class Files implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "metadata")
    String metadata;
}
