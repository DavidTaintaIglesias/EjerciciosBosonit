package com.example.ejercicioEJ2Refactorizado.infrastructure.controllers;

import com.example.ejercicioEJ2Refactorizado.application.PersonaService;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioEJ2Refactorizado.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutController {

    @Autowired
    PersonaService personaService;

    //Modificar por id (problemas con el autoincrement)
    @PutMapping("/put/{id}")
    public PersonaOutputDTO putById(@PathVariable int id, @RequestBody PersonaInputDTO personaInputDTO) throws Exception {
        return personaService.putById(id, personaInputDTO);
    }
}