package com.ejercicios.DBA1.application.services;

import com.ejercicios.DBA1.domain.entities.PersonaDBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.input.PersonaInputDTODBA1;
import com.ejercicios.DBA1.infrastructure.controllers.dto.output.PersonaOutputDTODBA1;
import com.ejercicios.DBA1.infrastructure.repository.PersonaRepositoryDBA1;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class PersonaServiceDBA1 implements Serializable {


    @Autowired
    PersonaRepositoryDBA1 personaRepository;


    //Recibir todos las persona de mi BBDD
    public List<PersonaDBA1> getAll() {
        return  personaRepository.findAll();

    }

    //Buscar por ID
    public PersonaDBA1 getById(int id) throws Exception{
        return personaRepository.findById(id).orElseThrow(()->new NotFound("id no encontrado"));
    }


    //Buscar by User (En el caso de que User pueda repetirse, sino quitaria ArrayList
    public  PersonaDBA1 findByUser(String user){
        return personaRepository.findByUser(user);
    }

    //Borrar por id
    public String deleteById(int id) {
        PersonaDBA1 person = personaRepository.findById(id).orElseThrow(()-> new NotFound("Id no encontrado"));
        personaRepository.delete(person);
        return "persona " + id + " borrada.";
    }

    //Modificar por id
    public PersonaOutputDTODBA1 putById(int id, PersonaInputDTODBA1 personaInputDTO) throws EmptyResultDataAccessException{
        try{
            personaRepository.deleteById(id);
            PersonaDBA1 personaEntity = new PersonaDBA1(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTODBA1 personaOutputDTO = new PersonaOutputDTODBA1(personaEntity);
            return personaOutputDTO;
        } catch (EmptyResultDataAccessException e){
            PersonaDBA1 personaEntity = new PersonaDBA1(personaInputDTO);
            personaRepository.save(personaEntity);
            PersonaOutputDTODBA1 personaOutputDTO = new PersonaOutputDTODBA1(personaEntity);
            return personaOutputDTO;
        }
    }

    //Añadir personas
    public PersonaDBA1 setPersona(PersonaInputDTODBA1 personaDTO) throws Exception{
        if(personaDTO.user()!=null){
            if(personaDTO.user().length()<6 || personaDTO.user().length()>10){
                throw new Exception("User debe estar entre 6 y 10 caracteres");
            } else {
                PersonaDBA1 persona = new PersonaDBA1(personaDTO);//Convierto InputDTO en Entity con el constructor de Entity
                personaRepository.save(persona);//Almaceno Entity en mi repositorio
                System.out.println("Persona añadida");
                return persona;
            }
        } else {
            throw new Exception("User no puede estar vacio");
        }
    }
}