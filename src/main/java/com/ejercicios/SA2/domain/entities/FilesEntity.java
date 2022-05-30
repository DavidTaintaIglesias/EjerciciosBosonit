package com.ejercicios.SA2.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "files_table")
@Setter
@Getter
@NoArgsConstructor
public class FilesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "metadata")
    String metadata;

    @Column(name = "name")
    String name;

    @Column(name = "date")
    LocalDateTime date;

    @Column(name = "directory")
    String dir;

    public FilesEntity(String name, LocalDateTime date, String dir, String metadata){
        this.name = name;
        this.date = date;
        this.dir = dir;
        this.metadata = metadata;
    }
}
