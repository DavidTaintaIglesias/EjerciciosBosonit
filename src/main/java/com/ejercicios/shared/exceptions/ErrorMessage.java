package com.ejercicios.shared.exceptions;

import java.util.Date;

//Clase para customizar el JSON de respuesta
public class ErrorMessage {

    private Date timestamp;
    private int HttpCode;
    String mensaje;//mensaje de error

    public ErrorMessage(Date timestamp, String mensaje, int httpCode) {
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
