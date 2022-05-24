package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import com.ejercicios.EJS31.infrastructure.repository.ProfesorRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProfesorServiceEJS31 {

    @Autowired
    ProfesorRepositoryEJS31 profesorRepository;

    public List<ProfesorEJS31> getAll(){
        return profesorRepository.findAll();
    }

    public ProfesorEJS31 getById(int id){
        return profesorRepository.findById(id).orElseThrow(()->new NotFound("Profesor Id not foud"));
    }
}
