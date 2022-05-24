package com.ejercicios.EJS31.application.services;

import com.ejercicios.EJS31.infrastructure.repository.PersonRepositoryEJS31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    PersonRepositoryEJS31 personRepository;

    public String getLogin(String user, String password){
        return"";
    }
}
