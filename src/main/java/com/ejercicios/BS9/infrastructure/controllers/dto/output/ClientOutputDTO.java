package com.ejercicios.BS9.infrastructure.controllers.dto.output;

import com.ejercicios.BS9.domain.entities.ClientEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientOutputDTO {

  private Integer id;
  private Integer idUser;
  private int orders;

  public ClientOutputDTO(ClientEntity clientEntity) {

    setId(clientEntity.getId());
    setIdUser(clientEntity.getUser().getId());
    setOrders(clientEntity.getOrders());
  }

}
