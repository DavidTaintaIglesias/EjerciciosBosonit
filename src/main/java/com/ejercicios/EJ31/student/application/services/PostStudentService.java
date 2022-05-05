package com.ejercicios.EJ31.student.application.services;

import com.ejercicios.EJ31.person.domain.entities.PersonEntity;
import com.ejercicios.EJ31.person.infrastructure.repository.PersonRepository;
import com.ejercicios.EJ31.student.domain.entities.StudentEntity;
import com.ejercicios.EJ31.student.infrastructure.controllers.dto.input.StudentInputDTO;
import com.ejercicios.EJ31.student.infrastructure.controllers.dto.output.StudentOutputDTO;
import com.ejercicios.EJ31.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    PersonRepository personaRepository;

    public StudentOutputDTO postStudent(StudentInputDTO studentInputDTO){
        StudentEntity studentEntity = new StudentEntity(studentInputDTO);
        PersonEntity personaEntity = personaRepository.getById(studentInputDTO.getIdPersona());
        studentEntity.setPersona(personaEntity);
        studentRepository.save(studentEntity);
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentEntity);
        return studentOutputDTO;
    }
}
