package com.example.to_do_fullstack.service;

import com.example.to_do_fullstack.dto.TarefaDTO;
import com.example.to_do_fullstack.entity.Tarefa;


import java.util.List;
import java.util.Optional;


public interface TarefaService {
    Optional<Tarefa> buscarPorId(Long id);
    Tarefa criarTarefa(Tarefa tarefa);
    void deletar(Long id);
    Optional<Tarefa> atualizarTarefa(Long id, Tarefa tarefa);
    List<Tarefa> listarTodas();
}
