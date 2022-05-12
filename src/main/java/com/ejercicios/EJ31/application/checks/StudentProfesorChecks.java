package com.ejercicios.EJ31.application.checks;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.Profesor;
import com.ejercicios.EJ31.domain.entities.Student;
import com.ejercicios.EJ31.infrastructure.repository.ProfesorRepository;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProfesorChecks {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ProfesorRepository profesorRepository;

    public void profesorCheck(int id){
        profesorRepository.findById(id).orElseThrow(()->new NotFoundException("Profesor Id not found"));
    }

    public void addProfesorToStudent(int idProfesor, int idStudent){
        Profesor profesor = profesorRepository.getById(idProfesor);
        Student student = studentRepository.getById(idStudent);
        student.setProfesor(profesor);
        studentRepository.save(student);
    }
}
