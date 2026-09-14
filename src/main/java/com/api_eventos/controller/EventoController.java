package com.api_eventos.controller;

import com.api_eventos.dto.EventoDto;
import com.api_eventos.dto.EventoResponse;
import com.api_eventos.model.Evento;
import com.api_eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoResponse> listar(){
        return eventoService.listar();
    }

    @PostMapping
    public ResponseEntity<EventoResponse> cadastrar(@RequestBody EventoDto evento){
        EventoResponse eventosalvo = eventoService.cadastrar(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventosalvo);
    }

    @GetMapping("/{id}")
    public EventoResponse listarPorId(@PathVariable Long id){
        return eventoService.buscarId(id);
    }
}
