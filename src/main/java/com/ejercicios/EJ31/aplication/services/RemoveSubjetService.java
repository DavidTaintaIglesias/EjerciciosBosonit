package com.ejercicios.EJ31.aplication.services;

import com.ejercicios.EJ31.domain.entities.SchoolSubjetEntity;
import com.ejercicios.EJ31.domain.entities.StudentEntity;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import com.ejercicios.EJ31.infrastructure.repository.SubjetRepository;
import com.ejercicios.shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveSubjetService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjetRepository subjetRepository;

    public String removeSubjetFromStudent(int id, int idSubjet){
        StudentEntity student = studentRepository.findById(id).orElseThrow(()-> new NotFoundException("Id no encontrado"));
        SchoolSubjetEntity subjet = subjetRepository.findById(idSubjet).orElseThrow(()-> new NotFoundException("Id de asignatura no encontrado"));
        student.getSubjetList().remove(subjet);
        studentRepository.save(student);
        return "Asignatura "+idSubjet+" borrada del estudiante "+id;
    }
}
