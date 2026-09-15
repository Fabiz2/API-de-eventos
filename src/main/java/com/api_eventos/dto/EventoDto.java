package com.api_eventos.dto;

import java.time.LocalDate;
import java.util.Date;

public record EventoDto(
        String nome,
        String descricao,
        LocalDate data,
        String local,
        Integer cap_maxima
) {
}
