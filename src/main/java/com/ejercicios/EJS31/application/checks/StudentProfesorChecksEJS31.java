package com.ejercicios.EJS31.application.checks;

import com.ejercicios.EJS31.domain.entities.ProfesorEJS31;
import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.infrastructure.repository.ProfesorRepositoryEJS31;
import com.ejercicios.EJS31.infrastructure.repository.StudentRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProfesorChecksEJS31 {

    @Autowired
    StudentRepositoryEJS31 studentRepository;

    @Autowired
    ProfesorRepositoryEJS31 profesorRepository;

    public void profesorCheck(int id){
        profesorRepository.findById(id).orElseThrow(()->new NotFound("Profesor Id not found"));
    }

    public void addProfesorToStudent(int idProfesor, int idStudent){
        ProfesorEJS31 profesor = profesorRepository.getById(idProfesor);
        StudentEJS31 student = studentRepository.getById(idStudent);
        student.setProfesor(profesor);
        studentRepository.save(student);
    }
}
