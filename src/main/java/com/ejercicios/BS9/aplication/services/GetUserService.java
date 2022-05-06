package com.ejercicios.BS9.aplication.services;

import com.ejercicios.BS9.domain.entities.UserEntity;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.UserOutputDTO;
import com.ejercicios.BS9.infrastructure.repository.UserRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserService {

    @Autowired
    UserRepository userRepository;

    public List<UserOutputDTO> getAll(){
        List<UserEntity> users =  userRepository.findAll();
        return users.stream().map(UserOutputDTO::new).toList();
    }

    public UserOutputDTO getById(int id){
        UserOutputDTO userOutputDTO = new UserOutputDTO(userRepository.findById(id).orElseThrow(()->new NotFoundException("ID no encontrado")));
        return userOutputDTO;
    }
}
