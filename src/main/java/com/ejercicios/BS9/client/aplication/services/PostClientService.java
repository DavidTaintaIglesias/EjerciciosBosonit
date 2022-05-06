package com.ejercicios.BS9.client.aplication.services;

import com.ejercicios.BS9.client.domain.entities.ClientEntity;
import com.ejercicios.BS9.client.infrastructure.controllers.dto.input.ClientInputDTO;
import com.ejercicios.BS9.client.infrastructure.controllers.dto.output.ClientOutputDTO;
import com.ejercicios.BS9.client.infrastructure.repository.ClientRepository;
import com.ejercicios.BS9.user.domain.entities.UserEntity;
import com.ejercicios.BS9.user.infrastructure.repository.UserRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.shared.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    UserRepository userRepository;

    public ClientOutputDTO postClient(ClientInputDTO clientInputDTO){
        ClientEntity clientEntity = new ClientEntity(clientInputDTO);
        UserEntity userEntity = userRepository.findById(clientInputDTO.getIdUser()).orElseThrow(()->new NotFoundException("Id de usuario no encontrado"));
        if(userEntity.getIdClient()==null){
            clientEntity.setUser(userEntity);
            clientRepository.save(clientEntity);
            userEntity.setIdClient(clientEntity.getId());
            userRepository.save(userEntity);
        } else throw new UnprocessableException("Este usuario ya tiene otro cliente asignado");
        ClientOutputDTO clientOutputDTO = new ClientOutputDTO(clientEntity);
        return clientOutputDTO;
    }
}
