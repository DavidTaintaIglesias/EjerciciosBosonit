package com.ejercicios.BS9.domain.entities;

import com.ejercicios.BS9.infrastructure.controllers.dto.input.UserInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_user")
  Integer id;

  @Column(name = "user_name")
  String name;

  @Column(name = "user_surname")
  String surname;

  @Column(name = "edad")
  int age;

  @Column(name = "id_client")
  Integer idClient;

  public UserEntity(UserInputDTO userInputDTO) {

    setName(userInputDTO.getName());
    setSurname(userInputDTO.getSurname());
    setAge(userInputDTO.getAge());
  }

}
