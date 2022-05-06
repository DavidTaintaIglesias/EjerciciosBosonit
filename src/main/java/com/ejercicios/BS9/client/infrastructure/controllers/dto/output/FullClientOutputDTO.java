package com.ejercicios.BS9.client.infrastructure.controllers.dto.output;

import com.ejercicios.BS9.client.domain.entities.ClientEntity;
import com.ejercicios.BS9.user.domain.entities.UserEntity;
import lombok.Data;

@Data
public class FullClientOutputDTO {

    private Integer id;
    private UserEntity userEntity;
    private int orders;

    public FullClientOutputDTO (ClientEntity clientEntity){
        setId(clientEntity.getId());
        setUserEntity(clientEntity.getUser());
        setOrders(clientEntity.getOrders());
    }
}
