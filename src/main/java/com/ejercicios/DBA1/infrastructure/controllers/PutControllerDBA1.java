package com.ejercicios.DBA1.infrastructure.controllers;

import com.ejercicios.DBA1.application.services.PersonaServiceDBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.input.PersonaInputDTODBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.output.PersonaOutputDTODBA1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "DBA1")
@RestController
@RequestMapping("/DBA1")
public class PutControllerDBA1 {

    @Autowired
    PersonaServiceDBA1 personaService;

    //Modificar por id (problemas con el autoincrement)
    @PutMapping("/put/{id}")
    public ResponseEntity<PersonaOutputDTODBA1> putById(@PathVariable int id, @RequestBody PersonaInputDTODBA1 personaInputDTO) throws EmptyResultDataAccessException {
        return new ResponseEntity<>(new PersonaOutputDTODBA1(personaService.putById(id, personaInputDTO)), HttpStatus.CREATED);
    }
}