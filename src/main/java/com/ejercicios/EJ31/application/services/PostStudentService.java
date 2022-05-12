package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.application.checks.StudentPersonChecks;
import com.ejercicios.EJ31.application.checks.StudentProfesorChecks;
import com.ejercicios.EJ31.domain.entities.Student;
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
    StudentPersonChecks checkPerson;

    @Autowired
    StudentProfesorChecks checkProfesor;

    public StudentOutputDTO postStudent(StudentInputDTO studentInputDTO){
        checkPerson.personCheck(studentInputDTO.getIdPerson());
        checkPerson.validStudent(studentInputDTO.getIdPerson());
        checkProfesor.profesorCheck(studentInputDTO.getIdProfesor());
        Student student = new Student(studentInputDTO);
        studentRepository.save(student);
        checkPerson.addPersontoStudent(studentInputDTO.getIdPerson(),student.getId());
        checkProfesor.addProfesorToStudent(studentInputDTO.getIdProfesor(),student.getId());
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(student);
        return studentOutputDTO;
    }
}
