package com.ejercicios.BS8.infrastructure.controllers;

import com.ejercicios.BS8.aplication.services.GetPersonaService;
import com.ejercicios.BS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BS8/get")
public class GetPersonaController {

  @Autowired
  GetPersonaService getPersonsService;

  //getAll
  @GetMapping("/all")
  public List<PersonaOutputDTO> getPersonas() {

    return getPersonsService.getAll();
  }

  //getByID
  @GetMapping("/byid/{id}")
  public PersonaOutputDTO getById(@PathVariable int id) {

    return getPersonsService.getById(id);
  }

  //getByUser
  @GetMapping("/byuser/{user}")
  public PersonaOutputDTO getByUser(@PathVariable String user) {

    return getPersonsService.getByUser(user);
  }


}
