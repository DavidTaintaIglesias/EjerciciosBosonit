package com.ejercicios.JVA2.infrastructure.controllers;

import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.input.PersonaInputDTOJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.output.PersonaOutputDTOJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/JVA2")
public class PutControllerJVA2 {

    @Autowired
    PersonaServiceJVA2 personaService;

    //Modificar por id (problemas con el autoincrement)
    @PutMapping("/put/{id}")
    public PersonaOutputDTOJVA2 putById(@PathVariable int id, @RequestBody PersonaInputDTOJVA2 personaInputDTO) throws EmptyResultDataAccessException {
        return personaService.putById(id, personaInputDTO);
    }
}