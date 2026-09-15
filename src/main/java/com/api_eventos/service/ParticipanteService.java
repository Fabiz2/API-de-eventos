package com.api_eventos.service;

import com.api_eventos.dto.ParticipanteDto;
import com.api_eventos.dto.ParticipanteResponse;
import com.api_eventos.exception.EmailDuplicadoException;
import com.api_eventos.model.Participante;
import com.api_eventos.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    public ParticipanteResponse toDTO(Participante participante){
        return new ParticipanteResponse(
            participante.getId(),
            participante.getNome(),
            participante.getEmail()
        );
    }

    public ParticipanteResponse cadastrar(ParticipanteDto participanteDto){
        if (participanteRepository.existsByEmail(participanteDto.email())){
            throw new EmailDuplicadoException();
        }
        Participante participante = new Participante();

        participante.setNome(participanteDto.nome());
        participante.setEmail(participanteDto.email());

        return toDTO(participanteRepository.save(participante));
    }

    public ParticipanteResponse buscarId(Long id){
        Participante participante = participanteRepository.findById(id).orElseThrow(() -> new RuntimeException("Participante não encontrado"));

        return toDTO(participante);
    }

    public List<ParticipanteResponse> listar(){
        return participanteRepository.findAll()
                .stream()
                .map(participante -> toDTO(participante))
                .toList();
    }



}
