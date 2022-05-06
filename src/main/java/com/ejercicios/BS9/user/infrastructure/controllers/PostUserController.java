package com.ejercicios.BS9.user.infrastructure.controllers;

import com.ejercicios.BS9.user.aplication.services.PostUserService;
import com.ejercicios.BS9.user.infrastructure.controllers.dto.input.UserInputDTO;
import com.ejercicios.BS9.user.infrastructure.controllers.dto.output.UserOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BS9")
public class PostUserController {

    @Autowired
    PostUserService postUserService;

    @PostMapping("/postuser")
    public UserOutputDTO postUser(@RequestBody UserInputDTO userInputDTO){
        return postUserService.postUser(userInputDTO);
    }
}
