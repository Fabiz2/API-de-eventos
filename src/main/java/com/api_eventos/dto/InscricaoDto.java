package com.api_eventos.dto;

import com.api_eventos.model.Evento;
import com.api_eventos.model.Participante;

import java.util.Date;

public record InscricaoDto(
        Long evento_id,
        Long participante_id,
        Date data_inscricao
) {
}
