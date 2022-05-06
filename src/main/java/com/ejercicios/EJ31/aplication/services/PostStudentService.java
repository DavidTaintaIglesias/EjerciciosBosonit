package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.domain.entities.PersonEntity;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import com.ejercicios.shared.exceptions.UnprocessableException;
import com.ejercicios.EJ31.domain.entities.StudentEntity;
import com.ejercicios.EJ31.infrastructure.controllers.dto.input.StudentInputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.StudentOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personRepository;

    public StudentOutputDTO postStudent(StudentInputDTO studentInputDTO){
        StudentEntity studentEntity = new StudentEntity(studentInputDTO);
        PersonEntity personaEntity = personRepository.findById(studentInputDTO.getIdPerson()).orElseThrow(()-> new NotFoundException("No hay personas con ese ID"));
        if(personaEntity.getProfesorEntity()==null){
            if(personaEntity.getStudentEntity()==null){
                studentEntity.setPersonEntity(personaEntity);
                studentRepository.save(studentEntity);
                personaEntity.setStudentEntity(studentEntity);
                personRepository.save(personaEntity);
            } else throw new UnprocessableException("La persona tiene un id de alumno asignado");
        } else throw new UnprocessableException("La persona elegida es profesor no puede ser estudiante");
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentEntity);
        return studentOutputDTO;
        //error contiene persona a estudiante y al revs todo el rato, solucionar
    }
}