package com.ejercicios.BS8.aplication.exceptions;

import java.util.Date;

//Clase para customizar el JSON de respuesta
public class CustomizedError {

    private Date timestamp;
    private int HttpCode;
    String mensaje;//mensaje de error

    public CustomizedError(Date timestamp, String mensaje, int httpCode) {
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
