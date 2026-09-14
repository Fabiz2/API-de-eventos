package com.api_eventos.dto;

import java.util.Date;

public record EventoDto(
        String nome,
        String descricao,
        Date data,
        String local,
        Integer cap_maxima

) {
}
