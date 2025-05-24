package com.api_tarefas.api_tarefas.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TarefaRequestDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 3, max = 200, message = "O título deve ter entre 3 e 200 caracteres")
    private String titulo;

    @Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres")
    private String descricao;

    @FutureOrPresent(message = "O prazo deve ser uma data futura ou presente")
    private LocalDate prazo;

    private Boolean concluida;
}
