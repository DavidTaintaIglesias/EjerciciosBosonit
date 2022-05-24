package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.PersonInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersonServiceEJS31 {

    @Autowired
    PersonRepositoryEJS31 personRepository;

    public PersonEJS31 postPerson(PersonInputDTOEJS31 personInputDTO){
        PersonEJS31 person = new PersonEJS31(personInputDTO);
        personRepository.save(person);
        return person;
    }
}
