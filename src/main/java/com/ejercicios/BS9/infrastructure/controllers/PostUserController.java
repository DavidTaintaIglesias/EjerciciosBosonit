package com.ejercicios.BS9.infrastructure.controllers;

import com.ejercicios.BS9.aplication.services.PostUserService;
import com.ejercicios.BS9.infrastructure.controllers.dto.input.UserInputDTO;
import com.ejercicios.BS9.infrastructure.controllers.dto.output.UserOutputDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "BS9")
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
