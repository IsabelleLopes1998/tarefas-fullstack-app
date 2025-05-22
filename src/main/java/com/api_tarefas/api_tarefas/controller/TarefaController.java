package com.api_tarefas.api_tarefas.controller;

import com.api_tarefas.api_tarefas.dto.TarefaRequestDTO;
import com.api_tarefas.api_tarefas.dto.TarefaResponseDTO;
import com.api_tarefas.api_tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTarefas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        TarefaResponseDTO dto = tarefaService.buscarPorId(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@Valid @RequestBody TarefaRequestDTO dto) {
        TarefaResponseDTO resposta = tarefaService.criarTarefa(dto);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TarefaRequestDTO dto) {
        TarefaResponseDTO resposta = tarefaService.atualizarTarefa(id, dto);
        return resposta != null ? ResponseEntity.ok(resposta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }
}
