package com.example.ejercicioBS8.util;

import com.example.ejercicioBS8.util.CustomError;
import com.example.ejercicioBS8.util.NotFoundException;
import com.example.ejercicioBS8.util.UnprocessableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

//Clase para introducir mi customizacion a los errores recibidos
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError> handleNotFoundException(NotFoundException ex, WebRequest request){
        CustomError customError = new CustomError(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<CustomError>(customError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableException.class)
    public final ResponseEntity<CustomError> handleUnprocessableException(UnprocessableException ex, WebRequest request){
        CustomError customError = new CustomError(new Date(), ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        return new ResponseEntity<CustomError>(customError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
