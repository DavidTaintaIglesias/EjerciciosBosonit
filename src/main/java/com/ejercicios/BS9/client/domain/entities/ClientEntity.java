package com.ejercicios.BS9.client.domain.entities;

import com.ejercicios.BS9.client.infrastructure.controllers.dto.input.ClientInputDTO;
import com.ejercicios.BS9.user.domain.entities.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
public class ClientEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    Integer id;

    @OneToOne
    @JoinColumn(name = "id_user")
    UserEntity user;

    @Column(name = "num_of_orders")
    int orders;

    public ClientEntity (ClientInputDTO clientInputDTO){
        setOrders(clientInputDTO.getOrders());
    }
}
