package com.ejercicios.BS8.aplication.services;

import com.ejercicios.BS8.aplication.exceptions.NotFound;
import com.ejercicios.BS8.domain.entities.PersonaEntity;
import com.ejercicios.BS8.infrastructure.controllers.dto.output.PersonaOutputDTO;
import com.ejercicios.BS8.infrastructure.repository.PersonaRepo;
import com.ejercicios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonaService {

    @Autowired
    PersonaRepo personaRepository;

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
