package com.api_eventos.exception;

public class EmailDuplicadoException extends RuntimeException {
    public EmailDuplicadoException() {
        super("Esse email já esta cadastrado.");
    }
}
