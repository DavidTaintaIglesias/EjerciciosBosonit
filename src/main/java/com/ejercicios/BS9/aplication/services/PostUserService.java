package com.ejercicios.BS9.aplication.services;

import com.ejercicios.BS9.domain.entities.UserEntity;
import com.ejercicios.BS9.infrastructure.controllers.dto.input.UserInputDTO;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.UserOutputDTO;
import com.ejercicios.BS9.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostUserService {

    @Autowired
    UserRepository userRepository;

    public UserOutputDTO postUser(UserInputDTO userInputDTO){
        UserEntity user = new UserEntity(userInputDTO);
        userRepository.save(user);
        UserOutputDTO userOutputDTO = new UserOutputDTO(user);
        return userOutputDTO;
    }
}
