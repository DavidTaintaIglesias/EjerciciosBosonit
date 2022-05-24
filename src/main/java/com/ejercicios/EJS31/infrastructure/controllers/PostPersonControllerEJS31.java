package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.PostPersonServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.PersonInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.PersonOutputDTOEJS31;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31")
public class PostPersonControllerEJS31 {

    @Autowired
    PostPersonServiceEJS31 postPersonService;

    @PostMapping("/postPerson")
    public PersonOutputDTOEJS31 postPerson(@Valid @RequestBody PersonInputDTOEJS31 personInputDTO){
        return postPersonService.postPerson(personInputDTO);
    }
}
