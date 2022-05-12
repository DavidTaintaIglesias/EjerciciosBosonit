package com.ejercicios.BS9.infrastructure.controllers.dto.output;

import com.ejercicios.BS9.domain.entities.UserEntity;
import lombok.Data;

@Data
public class UserOutputDTO {

  private Integer id;
  private String name;
  private String surname;
  private int age;
  private Integer idCliente;

  public UserOutputDTO(UserEntity userEntity) {

    setId(userEntity.getId());
    setName(userEntity.getName());
    setSurname(userEntity.getSurname());
    setAge(userEntity.getAge());
    if (userEntity.getIdClient() != null) {
      setIdCliente(userEntity.getIdClient());
    } else setIdCliente(0);
  }

}
