package com.ejercicioexamen.app.excepcion;

public class NotFound extends Exception {
    private String message;

    public NotFound(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

   
}
