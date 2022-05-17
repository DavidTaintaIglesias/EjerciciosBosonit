package com.ejercicios.DBA1.infrastructure.controllers;

import com.ejercicios.DBA1.application.services.PersonaServiceDBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.output.PersonaOutputDTODBA1;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "DBA1")
@RestController
@RequestMapping("/DBA1")
public class GetControllerDBA1 {

    @Autowired
    PersonaServiceDBA1 personaService;

    //Ver todos los valores
    @GetMapping("/getall")
    public ResponseEntity<List<PersonaOutputDTODBA1>> getPersonas(){
        return new ResponseEntity<>(personaService.getAll().stream().map(PersonaOutputDTODBA1::new).toList(), HttpStatus.OK);
    }

    //Buscar por id
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<PersonaOutputDTODBA1> getPersonById(@PathVariable int id) throws Exception{
        return new ResponseEntity<>(new PersonaOutputDTODBA1(personaService.getById(id)), HttpStatus.OK);
    }

    //Buscar por User
    @GetMapping("/getbyuser/{user}")
    public ResponseEntity<PersonaOutputDTODBA1> getPersonByUser(@PathVariable String user){
        return new ResponseEntity<>(new PersonaOutputDTODBA1(personaService.findByUser(user)), HttpStatus.OK);
    }
}