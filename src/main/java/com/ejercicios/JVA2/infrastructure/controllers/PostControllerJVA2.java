package com.ejercicios.JVA2.infrastructure.controllers;

import com.ejercicios.JVA2.application.services.PersonaServiceJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.input.PersonaInputDTOJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.output.PersonaOutputDTOJVA2;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = "JVA2")
@RestController
@RequestMapping("/JVA2")
public class PostControllerJVA2 {

    @Autowired
    PersonaServiceJVA2 personaService;

    //Añadir personaInputDTOJVA2
    @PostMapping("/postPerson")// simbolo "|" -> alt+124
    public ResponseEntity<PersonaOutputDTOJVA2> setPersona(@Valid @RequestBody PersonaInputDTOJVA2 personaInputDTOJVA2) throws Exception{

        return new ResponseEntity<>(new PersonaOutputDTOJVA2(personaService.setPersona(personaInputDTOJVA2)), HttpStatus.CREATED);

        /*
        //Constructor para el output record
        PersonaOutputDTOJVA2 personaOutput = new PersonaOutputDTOJVA2(
                person.getId(),
                person.getUser(),
                person.getPassword(),
                person.getName(),
                person.getSurname(),
                person.getCompanyEmail(),
                person.getPersonalEmail(),
                person.getCity(),
                person.getActive(),
                person.getDate(),
                person.getImageUrl(),
                person.getTerminationDate()
        );
         */
    }
}