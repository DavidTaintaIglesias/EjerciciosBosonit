package com.ejercicios.EJS31.infrastructure.controllers;

import com.ejercicios.EJS31.application.services.GetPersonServiceEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.PersonOutputDTOEJS31;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "EJS31")
@RestController
@RequestMapping("/EJS31/getPerson")
public class GetPersonControllerEJS31 {

    @Autowired
    GetPersonServiceEJS31 getPersonService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonOutputDTOEJS31>> getPersons(){
        return new ResponseEntity<>(getPersonService.getAllPerson().stream().map(PersonOutputDTOEJS31::new).toList(), HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<PersonOutputDTOEJS31> getById(@PathVariable int id){
        return new ResponseEntity<>(new PersonOutputDTOEJS31(getPersonService.getPersonById(id)), HttpStatus.OK);
    }

    @GetMapping("/byUser/{user}")
    public ResponseEntity<PersonOutputDTOEJS31> getByUser (@PathVariable String user){
        return new ResponseEntity<>(new PersonOutputDTOEJS31(getPersonService.getPersonByUser(user)), HttpStatus.OK);
    }
}
