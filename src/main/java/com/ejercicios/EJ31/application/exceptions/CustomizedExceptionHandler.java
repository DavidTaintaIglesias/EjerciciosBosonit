package com.ejercicios.EJ31.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//Clase para introducir mi customizacion a los errores recibidos
@RestControllerAdvice
public class CustomizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public final CustomError handleNotFoundException(NotFoundException ex){
        CustomError customError = new CustomError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return customError;
    }

    //Coge la fecha y hora, el mensaje obtenido del error y un valor http que queramos y lo introduce en mi Custom error
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)//Devuelve el error y el código de error http de la pagina al saltar este error
    @ExceptionHandler(UnprocessableException.class)
    public final CustomError handleUnprocessableException(UnprocessableException ex){
        CustomError customError = new CustomError(new Date(), ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        return customError;
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleBadRequest (MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();//Mapa de errores para recogerlos todos y mostrarlos a la vez
        ex.getBindingResult().getFieldErrors().forEach(e->errors.put(e.getField(), e.getDefaultMessage()));
        return errors;

    }
}
