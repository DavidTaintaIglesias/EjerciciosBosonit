package com.ejercicios.BS9.user.aplication.services;

import com.ejercicios.BS9.user.domain.entities.UserEntity;
import com.ejercicios.BS9.user.infrastructure.controllers.dto.input.UserInputDTO;
import com.ejercicios.BS9.user.infrastructure.controllers.dto.output.UserOutputDTO;
import com.ejercicios.BS9.user.infrastructure.repository.UserRepository;
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
