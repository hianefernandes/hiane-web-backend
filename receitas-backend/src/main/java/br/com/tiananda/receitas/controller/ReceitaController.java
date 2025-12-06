package com.tiaNanda.receitas.controller;

import com.tiaNanda.receitas.dto.ReceitaRequestDTO;
import com.tiaNanda.receitas.dto.ReceitaResponseDTO;
import com.tiaNanda.receitas.service.ApiExternaService;
import com.tiaNanda.receitas.service.ReceitaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitaController {

    private final ReceitaService service;
    private final ApiExternaService apiExternaService;

    @Value("${app.frontend.url:http://localhost:5173}")
    private String frontendUrl;

    public ReceitaController(ReceitaService service, ApiExternaService apiExternaService) {
        this.service = service;
        this.apiExternaService = apiExternaService;
    }

    // LISTA PAGINADA (já atende o professor)
    @GetMapping
    public ResponseEntity<Page<ReceitaResponseDTO>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Page<ReceitaResponseDTO> result = service.listarPaginado(page, size, sortBy);
        return ResponseEntity.ok(result);
    }

    // LISTA TODAS SEM PAGINAÇÃO
    @GetMapping("/all")
    public ResponseEntity<List<ReceitaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ReceitaResponseDTO> criar(@Valid @RequestBody ReceitaRequestDTO dto) {
        ReceitaResponseDTO created = service.criar(dto);
        URI location = URI.create("/api/receitas/" + created.getId());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ReceitaRequestDTO dto) {
        ReceitaResponseDTO updated = service.atualizar(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    // ENDPOINT PRA CONSUMIR API EXTERNA
    @GetMapping("/piada")
    public ResponseEntity<String> getPiada() {
        String resposta = apiExternaService.buscarPiada();
        return ResponseEntity.ok(resposta);
    }
}