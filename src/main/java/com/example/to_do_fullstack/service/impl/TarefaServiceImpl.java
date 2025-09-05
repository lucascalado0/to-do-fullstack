package com.example.to_do_fullstack.service.impl;

import com.example.to_do_fullstack.dto.TarefaDTO;
import com.example.to_do_fullstack.entity.Tarefa;
import com.example.to_do_fullstack.exception.TarefaNotFoundException;
import com.example.to_do_fullstack.mapper.TarefaMapper;
import com.example.to_do_fullstack.repository.TarefaRepository;
import com.example.to_do_fullstack.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {


    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


    @Override
    public Tarefa criarTarefa(Tarefa tarefa) {
        if (tarefa == null){
            throw new IllegalArgumentException("A tarefa não pode ser nula");
        }
        return tarefaRepository.save(tarefa);
    }

    @Override
    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    @Override
    public Optional<Tarefa> atualizarTarefa(Long id, Tarefa tarefa) {
        return tarefaRepository.findById(id).map(tarefaExistente -> {
                    tarefaExistente.setTitulo(tarefa.getTitulo());
                    tarefaExistente.setDescricao(tarefa.getDescricao());
                    tarefaExistente.setStatus(tarefa.getStatus());
                    return tarefaRepository.save(tarefaExistente);
                });
    }

    @Override
    public List<Tarefa> listarTodas() {
        return  tarefaRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        if (!tarefaRepository.existsById(id)){
            throw new TarefaNotFoundException("Tarefa com o ID: " + id + "não encontrada");
        } else {
            tarefaRepository.deleteById(id);
        }
    }
}
