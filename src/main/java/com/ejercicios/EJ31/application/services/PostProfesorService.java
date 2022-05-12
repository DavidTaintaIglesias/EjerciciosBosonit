package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.application.checks.ProfesorPersonChecks;
import com.ejercicios.EJ31.domain.entities.Profesor;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.ProfesorInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    ProfesorPersonChecks checkPerson;

    public ProfesorOutputDTO postProfesor (ProfesorInputDTO profesorInputDTO){
        checkPerson.personCheck(profesorInputDTO.getIdPerson());
        checkPerson.validProfesor(profesorInputDTO.getIdPerson());
        Profesor profesor = new Profesor(profesorInputDTO);
        profesorRepository.save(profesor);
        checkPerson.addPersonToProfesor(profesorInputDTO.getIdPerson(),profesor.getId());
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesor);
        return profesorOutputDTO;
    }
}
