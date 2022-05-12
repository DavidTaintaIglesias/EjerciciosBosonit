package com.ejercicios.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Clase para manejar el error UNPROCESSABLE_ENTITY
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class Unprocessable extends RuntimeException{

    public Unprocessable(String message){//Mensaje recibido por parametro
        super(message);
    }
}
