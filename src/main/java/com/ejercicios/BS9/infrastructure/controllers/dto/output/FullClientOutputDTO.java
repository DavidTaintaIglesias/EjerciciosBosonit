package com.ejercicios.BS9.infrastructure.controllers.dto.output;

import com.ejercicios.BS9.domain.entities.ClientEntity;
import com.ejercicios.BS9.domain.entities.UserEntity;
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
