package com.ejercicios.EJ31.application.exceptions;

import java.util.Date;

//Clase para customizar el JSON de respuesta
public class CustomError {

  String mensaje;//mensaje de error
  private Date timestamp;
  private int HttpCode;

  public CustomError(Date timestamp, String mensaje, int httpCode) {

    this.timestamp = timestamp;
    this.mensaje = mensaje;
    HttpCode = httpCode;
  }

  public Date getTimestamp() {

    return timestamp;
  }

  public int getHttpCode() {

    return HttpCode;
  }

  public String getMensaje() {

    return mensaje;
  }

}
