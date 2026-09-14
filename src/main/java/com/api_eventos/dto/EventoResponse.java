package com.api_eventos.dto;

import java.util.Date;

public record EventoResponse(
        Long id,
        String nome,
        String descricao,
        Date data,
        String local,
        Integer cap_maxima
) {

}
