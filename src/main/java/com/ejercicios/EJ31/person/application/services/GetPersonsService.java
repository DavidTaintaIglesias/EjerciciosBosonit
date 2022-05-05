package com.ejercicios.EJ31.person.application.services;

import com.ejercicios.EJ31.person.infrastructure.controllers.dto.output.FullPersonOutputDTO;
import com.ejercicios.EJ31.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.person.infrastructure.controllers.dto.output.PersonOutputDTO;
import com.ejercicios.EJ31.person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonsService {

    @Autowired
    PersonRepository personaRepository;

    public List<PersonOutputDTO> getAll(){
        List<PersonEntity> personas = personaRepository.findAll();
        return personas.stream().map(PersonOutputDTO::new).toList();//Con el stream.map convierto la lista en mi lista de DTO y lo muestro.
    }

    public List<FullPersonOutputDTO> getFullAll(){
        List<PersonEntity> persons = personaRepository.findAll();
        return persons.stream().map(FullPersonOutputDTO::new).toList();
    }

    public PersonOutputDTO getById(int id){
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personaRepository.findById(id).orElseThrow(()-> new NotFoundException("Id no encontrado")));
        return personaOutputDTO;
    }

    public FullPersonOutputDTO getFullById(int id){
        FullPersonOutputDTO fullPersonOutputDTO = new FullPersonOutputDTO(personaRepository.findById(id).orElseThrow(()->new NotFoundException("Id no encontrado")));
        return fullPersonOutputDTO;
    }

    public PersonOutputDTO getByUser(String user){
        PersonOutputDTO personaOutputDTO = new PersonOutputDTO(personaRepository.findByUser(user).orElseThrow(()-> new NotFoundException("User no encontrado")));
        return personaOutputDTO;
    }

    public FullPersonOutputDTO getFullByUser(String user){
        FullPersonOutputDTO fullPersonOutputDTO = new FullPersonOutputDTO(personaRepository.findByUser(user).orElseThrow(()-> new NotFoundException("User no encontrado")));
        return fullPersonOutputDTO;
    }
}
