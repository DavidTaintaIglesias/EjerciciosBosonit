package com.ejercicios.BS9.client.infrastructure.controllers;

import com.ejercicios.BS9.client.aplication.services.PostClientService;
import com.ejercicios.BS9.client.infrastructure.controllers.dto.input.ClientInputDTO;
import com.ejercicios.BS9.client.infrastructure.controllers.dto.output.ClientOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BS9/postclient")
public class PostClientController {

    @Autowired
    PostClientService postClientService;

    @PostMapping
    public ClientOutputDTO postClient(@RequestBody ClientInputDTO clientInputDTO){
        return postClientService.postClient(clientInputDTO);
    }
}
