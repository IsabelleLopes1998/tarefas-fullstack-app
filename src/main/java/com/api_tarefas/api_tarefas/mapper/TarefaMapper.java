package com.api_tarefas.api_tarefas.mapper;

import com.api_tarefas.api_tarefas.dto.TarefaRequestDTO;
import com.api_tarefas.api_tarefas.dto.TarefaResponseDTO;
import com.api_tarefas.api_tarefas.model.Tarefa;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TarefaMapper {

    public Tarefa toEntity(TarefaRequestDTO dto) {
        return Tarefa.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .prazo(dto.getPrazo())
                .dataCriacao(LocalDateTime.now())
                .concluida(false)
                .build();
    }

    public TarefaResponseDTO toResponseDTO(Tarefa entity) {
        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setDescricao(entity.getDescricao());
        dto.setConcluida(entity.isConcluida());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setPrazo(entity.getPrazo());
        return dto;
    }
}
