package com.api_eventos.exception;

public class InscricaoDuplicadaException extends RuntimeException {
    public InscricaoDuplicadaException() {
        super("Você ja está inscrito nesse evento");
    }
}
