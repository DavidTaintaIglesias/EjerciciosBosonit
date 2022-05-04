package com.example.ejercicioBS8.application.services;

import com.example.ejercicioBS8.application.exceptions.NotFoundException;
import com.example.ejercicioBS8.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonService {

    @Autowired
    PersonaRepository personaRepository;

    public String deleteById(int id){
        try {
            personaRepository.deleteById(id);
            return "Registro con id "+id+" borrado.";
        } catch (EmptyResultDataAccessException es){
            throw new NotFoundException("Id no encontrado");
        }
    }
}
