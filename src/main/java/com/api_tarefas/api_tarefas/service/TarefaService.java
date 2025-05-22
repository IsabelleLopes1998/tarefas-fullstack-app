package com.api_tarefas.api_tarefas.service;

import com.api_tarefas.api_tarefas.dto.TarefaRequestDTO;
import com.api_tarefas.api_tarefas.dto.TarefaResponseDTO;
import com.api_tarefas.api_tarefas.mapper.TarefaMapper;
import com.api_tarefas.api_tarefas.model.Tarefa;
import com.api_tarefas.api_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    public List<TarefaResponseDTO> listarTarefas() {
        return tarefaRepository.findAll().stream()
                .map(tarefaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public TarefaResponseDTO buscarPorId(Long id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        return optional.map(tarefaMapper::toResponseDTO).orElse(null);
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO dto) {
        Tarefa novaTarefa = tarefaMapper.toEntity(dto);
        novaTarefa = tarefaRepository.save(novaTarefa);
        return tarefaMapper.toResponseDTO(novaTarefa);
    }

    public TarefaResponseDTO atualizarTarefa(Long id, TarefaRequestDTO dto) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        if (optional.isPresent()) {
            Tarefa tarefa = optional.get();
            tarefa.setTitulo(dto.getTitulo());
            tarefa.setDescricao(dto.getDescricao());
            tarefa.setPrazo(dto.getPrazo());
            Tarefa atualizada = tarefaRepository.save(tarefa);
            return tarefaMapper.toResponseDTO(atualizada);
        }
        return null;
    }

    public void excluirTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
