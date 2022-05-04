package com.example.ejercicioBS8.application.services;

import com.example.ejercicioBS8.application.exceptions.UnprocessableException;
import com.example.ejercicioBS8.domain.entities.PersonaEntity;
import com.example.ejercicioBS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.example.ejercicioBS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.example.ejercicioBS8.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersonService {

    @Autowired
    PersonaRepository personaRepository;

    public PersonaOutputDTO addPersona (PersonaInputDTO personaInputDTO){
        if(personaInputDTO.getUser()!=null){
            if(personaInputDTO.getUser().length()<6 || personaInputDTO.getUser().length()>10){
                throw new UnprocessableException("User debe tener entre 6 y 10 caracteres");
            } else {
                PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
                personaRepository.save(personaEntity);
                PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
                return personaOutputDTO;
            }
        } else {
            throw new UnprocessableException("Falta el campo User");
        }
    }
}
