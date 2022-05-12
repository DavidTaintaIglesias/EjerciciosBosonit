package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.Person;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonOutputDTO> getAllPerson(){
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(PersonOutputDTO::new).toList();
    }

    public PersonOutputDTO getPersonById(int id){
        PersonOutputDTO personOutputDTO = new PersonOutputDTO(personRepository.findById(id).orElseThrow(()->new NotFoundException("Person Id not found")));
        return personOutputDTO;
    }


    public PersonOutputDTO getPersonByUser(String user){
        PersonOutputDTO personOutputDTO = new PersonOutputDTO(personRepository.findByUser(user).orElseThrow(()->new NotFoundException("User not found")));
        return personOutputDTO;
    }
}
