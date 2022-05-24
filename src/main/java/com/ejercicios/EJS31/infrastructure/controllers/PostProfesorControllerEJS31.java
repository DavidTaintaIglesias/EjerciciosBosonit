package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.PostProfesorServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.ProfesorInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.ProfesorOutputDTOEJS31;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31")
public class PostProfesorControllerEJS31 {

    @Autowired
    PostProfesorServiceEJS31 postProfesorService;

    @PostMapping("/postProfesor")
    public ResponseEntity<ProfesorOutputDTOEJS31> postProfesor(@Valid @RequestBody ProfesorInputDTOEJS31 profesorInputDTO){
        return new ResponseEntity<>(new ProfesorOutputDTOEJS31(postProfesorService.postProfesor(profesorInputDTO)), HttpStatus.CREATED);
    }
}
