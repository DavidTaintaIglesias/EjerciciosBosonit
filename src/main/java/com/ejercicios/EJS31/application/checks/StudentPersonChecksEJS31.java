package com.ejercicios.EJS31.application.checks;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.domain.entities.StudentEJS31;
import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import com.ejercicios.EJS31.infrastructure.repository.StudentRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import com.ejercicios.shared.exceptions.Unprocessable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPersonChecksEJS31 {

    @Autowired
    StudentRepositoryEJS31 studentRepository;

    @Autowired
    PersonRepositoryEJS31 personRepository;

    public void personCheck(int id){
        personRepository.findById(id).orElseThrow(()->new NotFound("Person Id not found"));
    }

    public void validStudent(int id){
        PersonEJS31 person = personRepository.getById(id);
        if(person.getIdStudent()!=null){
            throw  new Unprocessable("This Person is already a Student");
        }
        if(person.getIdProffesor()!=null){
            throw new Unprocessable("This person is already a Profesor");
        }
    }

    public void addPersontoStudent(int idPerson, int idStudent){
        PersonEJS31 person = personRepository.getById(idPerson);
        StudentEJS31 student = studentRepository.getById(idStudent);
        student.setPerson(person);
        studentRepository.save(student);
        person.setIdStudent(student.getId());
        personRepository.save(person);
    }
}
