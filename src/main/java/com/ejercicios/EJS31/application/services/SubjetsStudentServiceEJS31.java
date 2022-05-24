package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.domain.entities.SubjetEJS31;
import com.ejercicios.EJS31.infrastructure.repository.StudentRepositoryEJS31;
import com.ejercicios.EJS31.infrastructure.repository.SubjetsRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjetsStudentServiceEJS31 {

    @Autowired
    StudentRepositoryEJS31 studentRepository;

    @Autowired
    SubjetsRepositoryEJS31 subjetsRepository;

    public String addSubjet(int idStudent, int idSubjet){
        StudentEJS31 student = studentRepository.findById(idStudent).orElseThrow(()->new NotFound("Student Id not found"));
        SubjetEJS31 subjet = subjetsRepository.findById(idSubjet).orElseThrow(()-> new NotFound("Subjet Id not found"));
        student.addSubjet(subjet);
        studentRepository.save(student);
        return "Subjet "+idSubjet+" add to Student "+idStudent;
    }

    public String removeSubjet(int idStudent, int idSubjet){
        StudentEJS31 student = studentRepository.findById(idStudent).orElseThrow(()->new NotFound("Student Id not found"));
        SubjetEJS31 subjet = subjetsRepository.findById(idSubjet).orElseThrow(()-> new NotFound("Subjet Id not found"));
        student.removeSubjet(subjet);
        studentRepository.save(student);
        return "Subjet "+idSubjet+" delete from Student "+idStudent;
    }
}
