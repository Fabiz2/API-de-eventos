package com.api_eventos.exception;

import com.api_eventos.dto.EventoResponse;
import com.api_eventos.model.Evento;

public class VagasLimiteException extends RuntimeException {
    public VagasLimiteException() {
        super("Evento Lotado!");
    }
}
