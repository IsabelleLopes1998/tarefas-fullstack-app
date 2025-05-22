package com.api_tarefas.api_tarefas.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TarefaResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;
    private LocalDateTime dataCriacao;
    private LocalDate prazo;
}

