package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.application.checks.ProfesorPersonChecksEJS31;
import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.ProfesorInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.ProfesorOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.ProfesorRepositoryEJS31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostProfesorServiceEJS31 {

    @Autowired
    ProfesorRepositoryEJS31 profesorRepository;

    @Autowired
    ProfesorPersonChecksEJS31 checkPerson;

    public ProfesorOutputDTOEJS31 postProfesor (ProfesorInputDTOEJS31 profesorInputDTO){
        checkPerson.personCheck(profesorInputDTO.getIdPerson());
        checkPerson.validProfesor(profesorInputDTO.getIdPerson());
        ProfesorEJS31 profesor = new ProfesorEJS31(profesorInputDTO);
        profesorRepository.save(profesor);
        checkPerson.addPersonToProfesor(profesorInputDTO.getIdPerson(),profesor.getId());
        ProfesorOutputDTOEJS31 profesorOutputDTO = new ProfesorOutputDTOEJS31(profesor);
        return profesorOutputDTO;
    }
}
