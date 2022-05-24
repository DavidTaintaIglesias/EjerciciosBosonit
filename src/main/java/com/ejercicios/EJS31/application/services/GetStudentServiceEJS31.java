package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.infrastructure.repository.StudentRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStudentServiceEJS31 {

    @Autowired
    StudentRepositoryEJS31 studentRepository;

    public List<StudentEJS31> getAll(){
        return studentRepository.findAll();
    }

    public StudentEJS31 getById(int id){
        return studentRepository.findById(id).orElseThrow(()->new NotFound("Student Id not foud"));
    }

}
