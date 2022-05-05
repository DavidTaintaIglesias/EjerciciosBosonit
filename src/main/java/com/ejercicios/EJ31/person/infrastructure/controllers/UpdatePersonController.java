package com.ejercicios.EJ31.person.infrastructure.controllers;

import com.ejercicios.EJ31.person.application.services.UpdatePersonService;
import com.ejercicios.EJ31.person.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.person.infrastructure.controllers.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdatePersonController {

    @Autowired
    UpdatePersonService updatePersonService;

    @PutMapping("/updateperson/{id}")
    public PersonOutputDTO updatePerson(@PathVariable int id, @RequestBody PersonInputDTO personaInputDTO){
        return updatePersonService.updatePerson(id, personaInputDTO);
    }
}
