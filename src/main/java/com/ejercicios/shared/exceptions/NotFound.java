package com.ejercicios.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//Clase para gestionar el error NOT_FOUND
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {

  public NotFound(String message) {

    super(message);
  }

}
