package com.ejercicios.BS8.aplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

//Clase para introducir mi customizacion a los errores recibidos
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler(NotFound.class)
    public final ResponseEntity<CustomizedError> handleNotFoundException(NotFound ex){
        CustomizedError customError = new CustomizedError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<CustomizedError>(customError, HttpStatus.NOT_FOUND);
    }

    //Coge la fecha y hora, el mensaje obtenido del error y un valor http que queramos y lo introduce en mi Custom error
    @ExceptionHandler(Unprocessable.class)
    public final ResponseEntity<CustomizedError> handleUnprocessableException(Unprocessable ex){
        CustomizedError customError = new CustomizedError(new Date(), ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<CustomizedError>(customError, HttpStatus.UNPROCESSABLE_ENTITY);//Devuelve el error y el código de error http de la pagina al saltar este error
    }
}
