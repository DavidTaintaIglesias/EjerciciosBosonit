package com.ejercicios.BS8.aplication.services;

import com.ejercicios.BS8.aplication.exceptions.NotFound;
import com.ejercicios.BS8.infrastructure.repository.PersonaRepo;
import com.ejercicios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaService {

    @Autowired
    PersonaRepo personaRepository;

    public String deleteById(int id){
        try {
            personaRepository.deleteById(id);
            return "Registro con id "+id+" borrado.";
        } catch (EmptyResultDataAccessException es){
            throw new NotFoundException("Id no encontrado");
        }
    }
}
