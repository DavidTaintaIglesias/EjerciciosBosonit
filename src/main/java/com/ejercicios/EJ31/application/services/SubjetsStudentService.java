package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.Student;
import com.ejercicios.EJ31.domain.entities.Subjet;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import com.ejercicios.EJ31.infrastructure.repository.SubjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjetsStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjetsRepository subjetsRepository;

    public String addSubjet(int idStudent, int idSubjet){
        Student student = studentRepository.findById(idStudent).orElseThrow(()->new NotFoundException("Student Id not found"));
        Subjet subjet = subjetsRepository.findById(idSubjet).orElseThrow(()-> new NotFoundException("Subjet Id not found"));
        student.addSubjet(subjet);
        studentRepository.save(student);
        return "Subjet "+idSubjet+" add to Student "+idStudent;
    }

    public String removeSubjet(int idStudent, int idSubjet){
        Student student = studentRepository.findById(idStudent).orElseThrow(()->new NotFoundException("Student Id not found"));
        Subjet subjet = subjetsRepository.findById(idSubjet).orElseThrow(()-> new NotFoundException("Subjet Id not found"));
        student.removeSubjet(subjet);
        studentRepository.save(student);
        return "Subjet "+idSubjet+" delete from Student "+idStudent;
    }
}
