package com.api_eventos.dto;

import com.api_eventos.model.Evento;
import com.api_eventos.model.Participante;

import java.util.Date;

public record InscricaoDto(
        Evento evento,
        Participante participante,
        Date data_inscricao
) {
}
