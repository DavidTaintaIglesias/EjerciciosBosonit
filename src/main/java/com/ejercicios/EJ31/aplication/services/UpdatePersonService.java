package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonService {

    @Autowired
    PersonRepository personaRepository;

    public PersonOutputDTO updatePerson(int id, PersonInputDTO personaInputDTO){
        PersonEntity personaEntity = personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Id no encontrado"));
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personaEntity);
        return personaOutputDTO;
    }
}
