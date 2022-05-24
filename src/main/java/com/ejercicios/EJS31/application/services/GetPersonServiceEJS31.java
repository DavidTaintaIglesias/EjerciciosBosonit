package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.PersonOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonServiceEJS31 {

    @Autowired
    PersonRepositoryEJS31 personRepository;

    public List<PersonOutputDTOEJS31> getAllPerson(){
        List<PersonEJS31> persons = personRepository.findAll();
        return persons.stream().map(PersonOutputDTOEJS31::new).toList();
    }

    public PersonOutputDTOEJS31 getPersonById(int id){
        PersonOutputDTOEJS31 personOutputDTO = new PersonOutputDTOEJS31(personRepository.findById(id).orElseThrow(()->new NotFound("Person Id not found")));
        return personOutputDTO;
    }


    public PersonOutputDTOEJS31 getPersonByUser(String user){
        PersonOutputDTOEJS31 personOutputDTO = new PersonOutputDTOEJS31(personRepository.findByUser(user).orElseThrow(()->new NotFound("User not found")));
        return personOutputDTO;
    }
}
