package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.aplication.services.PostSubjetService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.SchoolSubjetInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.SchoolSubjetOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EJ31")
public class PostSubjetController {

    @Autowired
    PostSubjetService postSubjetService;

    @PostMapping("/postsubjet")
    public SchoolSubjetOutputDTO postSubjet(@RequestBody SchoolSubjetInputDTO schoolSubjetInputDTO){
        return postSubjetService.postSubjet(schoolSubjetInputDTO);
    }
}
