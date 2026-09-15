package com.api_eventos.controller;

import com.api_eventos.dto.InscricaoDto;
import com.api_eventos.dto.InscricaoResponse;
import com.api_eventos.service.InscricaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscricao")
public class InscricaoController {
    @Autowired
    private InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<InscricaoResponse> cadastrar(@RequestBody InscricaoDto inscricaoDto){
        InscricaoResponse inscricaoRealizada = inscricaoService.cadastrar(inscricaoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(inscricaoRealizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        inscricaoService.cancelarInscricao(id);
        return ResponseEntity.noContent().build();
    }
}
