package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.application.checks.StudentPersonChecksEJS31;
import com.ejercicios.EJS31.application.checks.StudentProfesorChecksEJS31;
import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.input.StudentInputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.StudentRepositoryEJS31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostStudentServiceEJS31 {

    @Autowired
    StudentRepositoryEJS31 studentRepository;

    @Autowired
    StudentPersonChecksEJS31 checkPerson;

    @Autowired
    StudentProfesorChecksEJS31 checkProfesor;

    public StudentEJS31 postStudent(StudentInputDTOEJS31 studentInputDTO){
        checkPerson.personCheck(studentInputDTO.getIdPerson());
        checkPerson.validStudent(studentInputDTO.getIdPerson());
        checkProfesor.profesorCheck(studentInputDTO.getIdProfesor());
        StudentEJS31 student = new StudentEJS31(studentInputDTO);
        studentRepository.save(student);
        checkPerson.addPersontoStudent(studentInputDTO.getIdPerson(),student.getId());
        checkProfesor.addProfesorToStudent(studentInputDTO.getIdProfesor(),student.getId());
        return student;
    }
}
