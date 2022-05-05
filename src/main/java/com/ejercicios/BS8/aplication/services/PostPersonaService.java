package com.ejercicios.BS8.aplication.services;

import com.ejercicios.BS8.aplication.exceptions.Unprocessable;
import com.ejercicios.BS8.domain.entities.PersonaEntity;
import com.ejercicios.BS8.infrastructure.controllers.dto.input.PersonaInputDTO;
import com.ejercicios.BS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.ejercicios.BS8.infrastructure.repository.PersonaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostPersonaService {

    @Autowired
    PersonaRepo personaRepository;

    public PersonaOutputDTO addPersona (PersonaInputDTO personaInputDTO){
        if(personaInputDTO.getUser()!=null){
            if(personaInputDTO.getUser().length()<6 || personaInputDTO.getUser().length()>10){
                throw new Unprocessable("User debe tener entre 6 y 10 caracteres");
            } else {
                PersonaEntity personaEntity = new PersonaEntity(personaInputDTO);
                personaRepository.save(personaEntity);
                PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaEntity);
                return personaOutputDTO;
            }
        } else {
            throw new Unprocessable("Falta el campo User");
        }
    }
}
