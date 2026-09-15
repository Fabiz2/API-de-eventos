package com.api_eventos.service;

import com.api_eventos.dto.*;
import com.api_eventos.exception.InscricaoDuplicadaException;
import com.api_eventos.exception.VagasLimiteException;
import com.api_eventos.model.Evento;
import com.api_eventos.model.Inscricao;
import com.api_eventos.model.Participante;
import com.api_eventos.repository.EventoRepository;
import com.api_eventos.repository.InscricaoRepository;
import com.api_eventos.repository.ParticipanteRepository;
import jdk.jfr.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository inscricaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    public InscricaoResponse toDTO(Inscricao inscricao){

        EventoDto eventoDto = new EventoDto(
                inscricao.getEvento().getNome(),
                inscricao.getEvento().getDescricao(),
                inscricao.getEvento().getData(),
                inscricao.getEvento().getLocal(),
                inscricao.getEvento().getCap_maxima()
        );

        ParticipanteDto participanteDto = new ParticipanteDto(
                inscricao.getParticipante().getNome(),
                inscricao.getParticipante().getEmail()
        );

        return new InscricaoResponse(
                inscricao.getId(),
                eventoDto,
                participanteDto,
                inscricao.getData_inscricao()
        );
    }

    public InscricaoResponse cadastrar(InscricaoDto inscricaoDto){

        Inscricao inscricao = new Inscricao();

        Evento evento = eventoRepository.findById(inscricaoDto.evento_id()).orElseThrow(() -> new RuntimeException("Evento nao encontrado"));

        Participante participante = participanteRepository.findById(inscricaoDto.participante_id()).orElseThrow(() -> new RuntimeException("Paticipante nao encontrado"));

        inscricao.setEvento(evento);
        inscricao.setParticipante(participante);
        inscricao.setData_inscricao(inscricaoDto.data_inscricao());

        if (inscricaoRepository.countByEventoId(evento.getId()) >= evento.getCap_maxima()){
            throw new VagasLimiteException();
        }

        if (inscricaoRepository.existsByEventoIdAndParticipanteId(
                evento.getId(),
                participante.getId()
        )) {
            throw new InscricaoDuplicadaException();
        }

        return toDTO(inscricaoRepository.save(inscricao));
    }
}
