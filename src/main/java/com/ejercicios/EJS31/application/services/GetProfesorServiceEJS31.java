package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.FullProfesorOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.ProfesorOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.ProfesorRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProfesorServiceEJS31 {

    @Autowired
    ProfesorRepositoryEJS31 profesorRepository;

    public List<ProfesorOutputDTOEJS31> getAll(){
        List<ProfesorEJS31> profesors = profesorRepository.findAll();
        return profesors.stream().map(ProfesorOutputDTOEJS31::new).toList();
    }

    public ProfesorOutputDTOEJS31 getById(int id){
        ProfesorOutputDTOEJS31 profesorOutputDTO = new ProfesorOutputDTOEJS31(profesorRepository.findById(id).orElseThrow(()->new NotFound("Profesor Id not foud")));
        return profesorOutputDTO;
    }

    public FullProfesorOutputDTOEJS31 getFullById(int id){
        FullProfesorOutputDTOEJS31 fullProfesorOutputDTO = new FullProfesorOutputDTOEJS31(profesorRepository.findById(id).orElseThrow(()->new NotFound("Profesor Id not found")));
        return fullProfesorOutputDTO;
    }
}
