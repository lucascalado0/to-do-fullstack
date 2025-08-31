package com.example.to_do_fullstack.service.impl;

import com.example.to_do_fullstack.dto.TarefaDTO;
import com.example.to_do_fullstack.entity.Tarefa;
import com.example.to_do_fullstack.mapper.TarefaMapper;
import com.example.to_do_fullstack.repository.TarefaRepository;
import com.example.to_do_fullstack.service.TarefaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {


    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaServiceImpl(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    @Override
    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return tarefaMapper.toDTO(tarefaSalva);
    }

    @Override
    public Optional<TarefaDTO> buscarPorId(Long id) {
        return tarefaRepository.findById(id)
                .map(tarefaMapper::toDTO);
    }

    @Override
    public Optional<TarefaDTO> atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        return tarefaRepository.findById(id)
                .map(tarefaExistente -> {
                    tarefaExistente.setTitulo(tarefaDTO.getTitulo());
                    tarefaExistente.setDescricao(tarefaDTO.getDescricao());
                    tarefaExistente.setStatus(tarefaDTO.getStatus());
                    Tarefa tarefaAtualizada = tarefaRepository.save(tarefaExistente);
                    return tarefaMapper.toDTO(tarefaAtualizada);
                });
    }

    @Override
    public List<TarefaDTO> listarTodas() {
        return  tarefaRepository.findAll()
                .stream()
                .map(tarefaMapper::toDTO)
                .toList();
    }

    @Override
    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)){
            throw new RuntimeException("Tarefa com o ID: " + id + "não encontrada");
        } else {
            tarefaRepository.deleteById(id);
        }
    }
}
