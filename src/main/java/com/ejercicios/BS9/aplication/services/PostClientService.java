package com.ejercicios.BS9.aplication.services;

import com.ejercicios.BS9.domain.entities.ClientEntity;
import com.ejercicios.BS9.domain.entities.UserEntity;
import com.ejercicios.BS9.infrastructure.controllers.dto.input.ClientInputDTO;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.ClientOutputDTO;
import com.ejercicios.BS9.infrastructure.repository.ClientRepository;
import com.ejercicios.BS9.infrastructure.repository.UserRepository;
import com.ejercicios.shared.exceptions.NotFound;
import com.ejercicios.shared.exceptions.Unprocessable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostClientService {

  @Autowired
  ClientRepository studentRepository;

  @Autowired
  UserRepository personRepository;

  public ClientOutputDTO postClient(ClientInputDTO clientInputDTO) {

    ClientEntity clientEntity = new ClientEntity(clientInputDTO);
    UserEntity userEntity = personRepository.findById(clientInputDTO.getIdUser()).orElseThrow(() -> new NotFound("Id de usuario no encontrado"));
    if (userEntity.getIdClient() == null) {
      clientEntity.setUser(userEntity);
      studentRepository.save(clientEntity);
      userEntity.setIdClient(clientEntity.getId());
      personRepository.save(userEntity);
    } else throw new Unprocessable("Este usuario ya tiene otro cliente asignado");
    ClientOutputDTO clientOutputDTO = new ClientOutputDTO(clientEntity);
    return clientOutputDTO;
  }

}
