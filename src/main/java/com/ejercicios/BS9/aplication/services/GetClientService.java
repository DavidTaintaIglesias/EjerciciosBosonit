package com.ejercicios.BS9.aplication.services;

import com.ejercicios.BS9.domain.entities.ClientEntity;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.ClientOutputDTO;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.FullClientOutputDTO;
import com.ejercicios.BS9.infrastructure.repository.ClientRepository;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientOutputDTO> getAll(){
        List<ClientEntity> clients = clientRepository.findAll();
        return clients.stream().map(ClientOutputDTO::new).toList();
    }

    public ClientOutputDTO getById(int id){
        ClientOutputDTO clientOutputDTO = new ClientOutputDTO(clientRepository.findById(id).orElseThrow(()-> new NotFound("Id no encontrado")));
        return clientOutputDTO;
    }

    public FullClientOutputDTO getFullById(int id){
        FullClientOutputDTO fullClientOutputDTO = new FullClientOutputDTO(clientRepository.findById(id).orElseThrow(()->new NotFound("Id no encontrado")));
        return fullClientOutputDTO;
    }
}
