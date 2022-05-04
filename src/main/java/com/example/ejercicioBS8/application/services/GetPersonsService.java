package com.example.ejercicioBS8.application.services;

import com.example.ejercicioBS8.application.exceptions.NotFoundException;
import com.example.ejercicioBS8.domain.entities.PersonaEntity;
import com.example.ejercicioBS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.example.ejercicioBS8.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonsService {

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaOutputDTO> getAll(){
        List<PersonaEntity> personas = personaRepository.findAll();
        return personas.stream().map(PersonaOutputDTO::new).toList();//Con el stream.map convierto la lista en mi lista de DTO y lo muestro.
    }

    public PersonaOutputDTO getById(int id){
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Id no encontrado")));
        return personaOutputDTO;
    }

    public PersonaOutputDTO getByUser(String user){
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(personaRepository.findByUser(user).orElseThrow(()-> new NotFoundException("User no encontrado")));
        return personaOutputDTO;
    }
}
