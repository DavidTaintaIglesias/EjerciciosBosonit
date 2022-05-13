package com.ejercicios.BS12.application.service;

import com.ejercicios.BS12.domain.entities.PersonBS12;
import com.ejercicios.BS12.infrastructure.controllers.dto.output.PersonOutputDTOBS12;
import com.ejercicios.BS12.infrastructure.repository.PersonRepositoryBS12;
import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonServiceBS12 {

  @Autowired
  PersonRepositoryBS12 personRepository;

  public List<PersonOutputDTOBS12> getAllPerson() {

    List<PersonBS12> persons = personRepository.findAll();
    return persons.stream().map(PersonOutputDTOBS12::new).toList();
  }

  public PersonOutputDTOBS12 getPersonById(int id) {

    PersonOutputDTOBS12 personOutputDTO = new PersonOutputDTOBS12(personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person Id not found")));
    return personOutputDTO;
  }


  public PersonOutputDTOBS12 getPersonByUser(String usuario) {

    PersonOutputDTOBS12 personOutputDTO = new PersonOutputDTOBS12(personRepository.findByUsuario(usuario).orElseThrow(() -> new NotFoundException("User not found")));
    return personOutputDTO;
  }

}
