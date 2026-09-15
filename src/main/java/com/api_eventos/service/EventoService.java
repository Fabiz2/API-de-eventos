package com.api_eventos.service;

import com.api_eventos.dto.EventoDto;
import com.api_eventos.dto.EventoResponse;
import com.api_eventos.model.Evento;
import com.api_eventos.model.Inscricao;
import com.api_eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public EventoResponse toDTO(Evento evento, List<String> participante){
        return new EventoResponse(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getData(),
                evento.getLocal(),
                evento.getCap_maxima(),
                participante
        );
    }

    public EventoResponse toDTO(Evento evento){
        return new EventoResponse(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getData(),
                evento.getLocal(),
                evento.getCap_maxima(),
                null
        );
    }


    public EventoResponse cadastrar(EventoDto eventoDto){
        Evento evento = new Evento();

        evento.setNome(eventoDto.nome());
        evento.setDescricao(eventoDto.descricao());
        evento.setData(eventoDto.data());
        evento.setLocal(eventoDto.local());
        evento.setCap_maxima(eventoDto.cap_maxima());

        return toDTO(eventoRepository.save(evento));
    }

    public EventoResponse buscarId(Long id){
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado!"));

        List<String> participantes = new ArrayList<>();

        for (Inscricao inscricao: evento.getInscricao()){
            participantes.add(inscricao.getParticipante().getNome());
        }

        return toDTO(evento, participantes);
    }

    public List<EventoResponse> listar(){
        return eventoRepository.findAll()
                .stream()
                .map(evento -> toDTO(evento))
                .toList();
    }
}
