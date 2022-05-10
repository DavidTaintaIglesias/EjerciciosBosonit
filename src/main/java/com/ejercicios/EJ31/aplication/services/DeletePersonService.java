package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import com.ejercicios.shared.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonService {

    @Autowired
    PersonRepository personaRepository;

    public String deleteById(int id){
        PersonEntity person = personaRepository.findById(id).orElseThrow(()->new NotFoundException("Id no encontrado"));
        if(person.getIdStudent()==null){
            if(person.getIdProfesor()==null){
                personaRepository.delete(person);
                return "Persona con id: "+id+" borrada.";
            } else throw new UnprocessableException("No se puede borrar la persona porque tiene un profesor asignado");
        } else throw new UnprocessableException("No se puede borrar la persona porque tiene un estudiante asignado");

    }
}
