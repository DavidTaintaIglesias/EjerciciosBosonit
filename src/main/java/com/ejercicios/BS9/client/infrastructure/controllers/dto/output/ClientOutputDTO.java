package com.ejercicios.BS9.client.infrastructure.controllers.dto.output;

import com.ejercicios.BS9.client.domain.entities.ClientEntity;
import com.ejercicios.BS9.user.domain.entities.UserEntity;
import lombok.Data;

@Data
public class ClientOutputDTO {

    private Integer id;
    private Integer idUser;
    private int orders;

    public ClientOutputDTO (ClientEntity clientEntity){
        setId(clientEntity.getId());
        setIdUser(clientEntity.getUser().getId());
        setOrders(clientEntity.getOrders());
    }
}
