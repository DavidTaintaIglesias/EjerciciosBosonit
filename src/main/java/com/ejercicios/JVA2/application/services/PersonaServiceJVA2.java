package com.ejercicios.JVA2.application.services;

import com.ejercicios.JVA2.domain.entities.PersonaJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.input.PersonaInputDTOJVA2;
import com.ejercicios.JVA2.infrastructure.controllers.dto.output.PersonaOutputDTOJVA2;
import com.ejercicios.JVA2.infrastructure.repository.PersonaRepositoryJVA2;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PersonaServiceJVA2 implements Serializable {


    @Autowired
    PersonaRepositoryJVA2 personaRepository;


    //Recibir todos las persona de mi BBDD
    public List<PersonaJVA2> getAll() {
        return  personaRepository.findAll();

    }

    //Buscar por ID
    public PersonaJVA2 getById(int id) throws Exception{
        return personaRepository.findById(id).orElseThrow(()->new NotFound("id no encontrado"));
    }


    //Buscar by User (En el caso de que User pueda repetirse, sino quitaria ArrayList
    public  PersonaJVA2 findByUser(String user){
        return personaRepository.findByUser(user);
    }

    //Borrar por id
    public String deleteById(int id) {
        PersonaJVA2 person = personaRepository.findById(id).orElseThrow(()-> new NotFound("Id no encontrado"));
        personaRepository.delete(person);
        return "persona " + id + " borrada.";
    }

    //Modificar por id
    public PersonaOutputDTOJVA2 putById(int id, PersonaInputDTOJVA2 personaInputDTO) throws EmptyResultDataAccessException{
        try{
            personaRepository.deleteById(id);
            PersonaJVA2 personaEntity = new PersonaJVA2(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTOJVA2 personaOutputDTO = new PersonaOutputDTOJVA2(personaEntity);
            return personaOutputDTO;
        } catch (EmptyResultDataAccessException e){
            PersonaJVA2 personaEntity = new PersonaJVA2(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTOJVA2 personaOutputDTO = new PersonaOutputDTOJVA2(personaEntity);
            return personaOutputDTO;
        }
    }

    //Añadir personas
    public PersonaJVA2 setPersona(PersonaInputDTOJVA2 personaDTO) throws Exception{
        if(personaDTO.user()!=null){
            if(personaDTO.user().length()<6 || personaDTO.user().length()>10){
                throw new Exception("User debe estar entre 6 y 10 caracteres");
            } else {
                PersonaJVA2 persona = new PersonaJVA2(personaDTO);//Convierto InputDTO en Entity con el constructor de Entity
                personaRepository.save(persona);//Almaceno Entity en mi repositorio
                System.out.println("Persona añadida");
                return persona;
            }
        } else {
            throw new Exception("User no puede estar vacio");
        }
    }
}