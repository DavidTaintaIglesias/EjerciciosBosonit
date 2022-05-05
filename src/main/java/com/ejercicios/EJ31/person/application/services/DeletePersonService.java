package com.ejercicios.EJ31.person.application.services;

import com.ejercicios.EJ31.shared.exceptions.NotFoundException;
import com.ejercicios.EJ31.person.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonService {

    @Autowired
    PersonRepository personaRepository;

    public String deleteById(int id){
        try {
            personaRepository.deleteById(id);
            return "Registro con id "+id+" borrado.";
        } catch (EmptyResultDataAccessException es){
            throw new NotFoundException("Id no encontrado");
        }
    }
}
