package com.api_eventos.repository;

import com.api_eventos.model.Inscricao;
import com.api_eventos.model.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    @Query("""
            SELECT COUNT (*) FROM inscricao i
            WHERE i.evento_id = :id
            """)
    Long countByEventoId(Long id);
}
