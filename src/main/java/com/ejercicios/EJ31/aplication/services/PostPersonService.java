package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.shared.exceptions.UnprocessableException;
import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.PersonInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.PersonOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersonService {

    @Autowired
    PersonRepository personaRepository;

    public PersonOutputDTO addPersona (PersonInputDTO personaInputDTO){
        if(personaInputDTO.getUser()!=null){
            if(personaInputDTO.getUser().length()<6 || personaInputDTO.getUser().length()>10){
                throw new UnprocessableException("User debe tener entre 6 y 10 caracteres");
            } else {
                PersonEntity personaEntity = new PersonEntity(personaInputDTO);
                personaRepository.save(personaEntity);
                PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personaEntity);
                return personaOutputDTO;
            }
        } else {
            throw new UnprocessableException("Falta el campo User");
        }
    }
}