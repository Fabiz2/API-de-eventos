package com.api_eventos.repository;

import com.api_eventos.model.Inscricao;
import com.api_eventos.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    Long countByEventoId(Long id);
    boolean existsByEventoIdAndParticipanteId(Long eventoId, Long participanteId);
}
