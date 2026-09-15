package com.api_eventos.service;

import com.api_eventos.dto.InscricaoDto;
import com.api_eventos.dto.InscricaoResponse;
import com.api_eventos.model.Inscricao;
import com.api_eventos.repository.InscricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscricaoService {
    @Autowired
    private InscricaoRepository inscricaoRepository;

    public InscricaoResponse toDTO(Inscricao inscricao){
        return new InscricaoResponse(
                inscricao.getId(),
                inscricao.getEvento(),
                inscricao.getParticipante(),
                inscricao.getData_inscricao()
        );
    }

    public InscricaoResponse cadastrar(InscricaoDto inscricaoDto){
        Inscricao inscricao = new Inscricao();

        inscricao.setEvento(inscricaoDto.evento());
        inscricao.setParticipante(inscricaoDto.participante());
        inscricao.setData_inscricao(inscricaoDto.data_inscricao());

        return toDTO(inscricaoRepository.save(inscricao));
    }


}
