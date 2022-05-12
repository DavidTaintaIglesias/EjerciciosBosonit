package com.ejercicios.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//Clase para introducir mi customizacion a los errores recibidos
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(NotFound.class)
    public final ResponseEntity<ErrorMessage> handleNotFoundException(NotFound ex){
        ErrorMessage customError = new ErrorMessage(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ErrorMessage>(customError, HttpStatus.NOT_FOUND);
    }

    //Coge la fecha y hora, el mensaje obtenido del error y un valor http que queramos y lo introduce en mi Custom error
    @ExceptionHandler(Unprocessable.class)
    public final ResponseEntity<ErrorMessage> handleUnprocessableException(Unprocessable ex){
        ErrorMessage customError = new ErrorMessage(new Date(), ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<ErrorMessage>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> badRequestHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.put(e.getField(), e.getDefaultMessage()));

        return errors;
    }
}
