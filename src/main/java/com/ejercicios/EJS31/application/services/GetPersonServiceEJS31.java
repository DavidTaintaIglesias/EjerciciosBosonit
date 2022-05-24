package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.domain.entities.PersonEJS31;
import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import com.ejercicios.shared.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonServiceEJS31 {

    @Autowired
    PersonRepositoryEJS31 personRepository;

    public List<PersonEJS31> getAllPerson(){
        return personRepository.findAll();

    }

    public PersonEJS31 getPersonById(int id){
        return personRepository.findById(id).orElseThrow(()->new NotFound("Person Id not found"));
    }


    public PersonEJS31 getPersonByUser(String user){
        return personRepository.findByUser(user).orElseThrow(()->new NotFound("User not found"));
    }
}
