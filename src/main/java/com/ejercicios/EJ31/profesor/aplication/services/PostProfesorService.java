package com.ejercicios.EJ31.profesor.aplication.services;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.person.infrastructure.repository.PersonRepository;
import com.ejercicios.EJ31.profesor.domain.entities.ProfesorEntity;
import com.ejercicios.EJ31.profesor.infrastructure.controllers.dto.input.ProfesorInputDTO;
import com.ejercicios.EJ31.profesor.infrastructure.controllers.dto.output.ProfesorOutputDTO;
import com.ejercicios.EJ31.profesor.infrastructure.repository.ProfesorRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.shared.exceptions.UnprocessableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostProfesorService {

    @Autowired
    ProfesorRepository profesorRepository;

    @Autowired
    PersonRepository personRepository;

    public ProfesorOutputDTO postProfesor(ProfesorInputDTO profesorInputDTO){
        ProfesorEntity profesorEntity = new ProfesorEntity(profesorInputDTO);
        PersonEntity personEntity = personRepository.findById(profesorInputDTO.getIdPerson()).orElseThrow(()-> new NotFoundException("No existe persona con ese ID"));
        if(personEntity.getStudentEntity()==null){
            if(personEntity.getProfesorEntity()==null){
                profesorEntity.setPersonEntity(personEntity);
                profesorRepository.save(profesorEntity);
                personEntity.setProfesorEntity(profesorEntity);
                personRepository.save(personEntity);
            }else throw new UnprocessableException("La persona ya tiene un id de profesor asignado");
        } else throw new UnprocessableException("La persona ya es alumno no puede ser profesor");
        ProfesorOutputDTO profesorOutputDTO = new ProfesorOutputDTO(profesorEntity);
        return profesorOutputDTO;
    }
}
