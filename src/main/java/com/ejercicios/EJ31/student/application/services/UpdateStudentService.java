package com.ejercicios.EJ31.student.application.services;

import com.ejercicios.EJ31.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStudentService {

    @Autowired
    StudentRepository studentRepository;
}
