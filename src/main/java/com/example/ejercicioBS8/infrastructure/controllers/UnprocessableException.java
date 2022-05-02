package com.example.ejercicioBS8.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Clase para manejar el error UNPROCESSABLE_ENTITY
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableException extends RuntimeException{

    public UnprocessableException (String message){
        super(message);
    }
}
