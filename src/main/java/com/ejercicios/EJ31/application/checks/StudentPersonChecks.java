package com.ejercicios.EJ31.application.checks;

import com.ejercicios.EJ31.application.exceptions.NotFoundException;
import com.ejercicios.EJ31.application.exceptions.UnprocessableException;
import com.ejercicios.EJ31.domain.entities.Person;
import com.ejercicios.EJ31.domain.entities.Student;
import com.ejercicios.EJ31.infrastructure.repository.PersonRepository;
import com.ejercicios.EJ31.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPersonChecks {

  @Autowired
  StudentRepository studentRepository;

  @Autowired
  PersonRepository personRepository;

  public void personCheck(int id) {

    personRepository.findById(id).orElseThrow(() -> new NotFoundException("Person Id not found"));
  }

  public void validStudent(int id) {

    Person person = personRepository.getById(id);
    if (person.getIdStudent() != null) {
      throw new UnprocessableException("This Person is already a Student");
    }
    if (person.getIdProfesor() != null) {
      throw new UnprocessableException("This person is already a Profesor");
    }
  }

  public void addPersontoStudent(int idPerson, int idStudent) {

    Person person = personRepository.getById(idPerson);
    Student student = studentRepository.getById(idStudent);
    student.setPerson(person);
    studentRepository.save(student);
    person.setIdStudent(student.getId());
    personRepository.save(person);
  }

}
