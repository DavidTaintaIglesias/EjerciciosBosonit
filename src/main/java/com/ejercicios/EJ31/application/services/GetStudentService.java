package com.ejercicios.EJ31.application.services;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.domain.entities.Student;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.FullStudentOutputDTO;
import com.ejercicios.EJ31.infrastructure.controllers.dto.output.StudentOutputDTO;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentOutputDTO> getAll(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentOutputDTO::new).toList();
    }

    public StudentOutputDTO getById(int id){
        StudentOutputDTO studentOutputDTO = new StudentOutputDTO(studentRepository.findById(id).orElseThrow(()->new NotFoundException("Student Id not foud")));
        return studentOutputDTO;
    }

    public FullStudentOutputDTO getFullById(int id){
        FullStudentOutputDTO fullStudentOutputDTO = new FullStudentOutputDTO(studentRepository.findById(id).orElseThrow(()->new NotFoundException("Student Id not foud")));
        return fullStudentOutputDTO;
    }
}
