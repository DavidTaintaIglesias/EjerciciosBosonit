package com.ejercicios.EJ31.infrastructure.controllers;

import com.ejercicios.EJ31.application.services.GetPersonService;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/EJ31/getPerson")
public class GetPersonController {

  @Autowired
  GetPersonService getPersonService;

  @GetMapping("/all")
  public List<PersonOutputDTO> getPersons() {

    return getPersonService.getAllPerson();
  }

  @GetMapping("/byId/{id}")
  public PersonOutputDTO getById(@PathVariable int id) {

    return getPersonService.getPersonById(id);
  }

  @GetMapping("/byUser/{user}")
  public PersonOutputDTO getByUser(@PathVariable String user) {

    return getPersonService.getPersonByUser(user);
  }

}
