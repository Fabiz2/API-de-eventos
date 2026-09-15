package com.api_eventos.model;

import jakarta.persistence.*;
import jakarta.servlet.http.Part;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Participante participante;

    @Column(nullable = false)
    private Date data_inscricao;
}
