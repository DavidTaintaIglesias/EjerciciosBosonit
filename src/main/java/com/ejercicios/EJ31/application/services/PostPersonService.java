package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.domain.entities.Person;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersonService {

  @Autowired
  PersonRepository personRepository;

  public PersonOutputDTO postPerson(PersonInputDTO personInputDTO) {

    Person person = new Person(personInputDTO);
    personRepository.save(person);
    PersonOutputDTO personOutputDTO = new PersonOutputDTO(person);
    return personOutputDTO;
  }

}
