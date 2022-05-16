package com.ejercicios.JVA2.infrastructure.controllers;

import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.output.PersonaOutputDTOJVA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/JVA2")
public class GetControllerJVA2 {

    @Autowired
    PersonaServiceJVA2 personaService;

    //Ver todos los valores
    @GetMapping("/getall")
    public ResponseEntity<List<PersonaOutputDTOJVA2>> getPersonas(){
        return new ResponseEntity<>(personaService.getAll().stream().map(PersonaOutputDTOJVA2::new).toList(), HttpStatus.ACCEPTED);
    }

    //Buscar por id
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PersonaOutputDTOJVA2> getPersonById(@PathVariable int id) throws Exception{
        return new ResponseEntity<>(new PersonaOutputDTOJVA2(personaService.getById(id)),HttpStatus.OK);
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public ResponseEntity<PersonaOutputDTOJVA2> getPersonByUser(@PathVariable String user){
        return new ResponseEntity<>(new PersonaOutputDTOJVA2(personaService.findByUser(user)),HttpStatus.OK);
    }
}