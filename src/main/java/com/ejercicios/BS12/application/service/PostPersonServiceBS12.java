package com.ejercicios.BS12.application.service;

import com.ejercicios.BS12.domain.entities.PersonBS12;
import com.ejercicios.BS12.infrastructure.controllers.dto.input.PersonInputDTOBS12;
import com.ejercicios.BS12.infrastructure.controllers.dto.output.PersonOutputDTOBS12;
import com.ejercicios.BS12.infrastructure.repository.PersonRepositoryBS12;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersonServiceBS12 {

    @Autowired
    PersonRepositoryBS12 personRepository;

    public PersonOutputDTOBS12 postPerson(PersonInputDTOBS12 personInputDTO){
        PersonBS12 person = new PersonBS12(personInputDTO);
        personRepository.save(person);
        PersonOutputDTOBS12 personOutputDTO = new PersonOutputDTOBS12(person);
        return personOutputDTO;
    }
}
