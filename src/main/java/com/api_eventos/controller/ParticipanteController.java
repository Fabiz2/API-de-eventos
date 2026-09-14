package com.api_eventos.controller;

import com.api_eventos.dto.EventoDto;
import com.api_eventos.dto.EventoResponse;
import com.api_eventos.dto.ParticipanteDto;
import com.api_eventos.dto.ParticipanteResponse;
import com.api_eventos.service.EventoService;
import com.api_eventos.service.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @GetMapping
    public List<ParticipanteResponse> listar(){
        return participanteService.listar();
    }

    @PostMapping
    public ResponseEntity<ParticipanteResponse> cadastrar(@RequestBody ParticipanteDto participante){
        ParticipanteResponse participantesalvo = participanteService.cadastrar(participante);
        return ResponseEntity.status(HttpStatus.CREATED).body(participantesalvo);
    }

    @GetMapping("/{id}")
    public ParticipanteResponse listarPorId(@PathVariable Long id){
        return participanteService.buscarId(id);
    }
}
