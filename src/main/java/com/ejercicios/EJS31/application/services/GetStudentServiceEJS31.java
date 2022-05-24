package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.FullStudentOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.controllers.dto.output.StudentOutputDTOEJS31;
import com.ejercicios.EJS31.infrastructure.repository.StudentRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStudentServiceEJS31 {

    @Autowired
    StudentRepositoryEJS31 studentRepository;

    public List<StudentOutputDTOEJS31> getAll(){
        List<StudentEJS31> students = studentRepository.findAll();
        return students.stream().map(StudentOutputDTOEJS31::new).toList();
    }

    public StudentOutputDTOEJS31 getById(int id){
        StudentOutputDTOEJS31 studentOutputDTO = new StudentOutputDTOEJS31(studentRepository.findById(id).orElseThrow(()->new NotFound("Student Id not foud")));
        return studentOutputDTO;
    }

    public FullStudentOutputDTOEJS31 getFullById(int id){
        FullStudentOutputDTOEJS31 fullStudentOutputDTO = new FullStudentOutputDTOEJS31(studentRepository.findById(id).orElseThrow(()->new NotFound("Student Id not foud")));
        return fullStudentOutputDTO;
    }
}
