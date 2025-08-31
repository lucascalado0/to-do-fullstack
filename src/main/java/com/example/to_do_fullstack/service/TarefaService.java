package com.example.to_do_fullstack.service;

import com.example.to_do_fullstack.dto.TarefaDTO;


import java.util.List;
import java.util.Optional;


public interface TarefaService {
    Optional<TarefaDTO> buscarPorId(Long id);
    TarefaDTO criarTarefa(TarefaDTO tarefaDTO);
    void deletar(Long id);
    Optional<TarefaDTO> atualizarTarefa(Long id, TarefaDTO tarefaDTO);
    List<TarefaDTO> listarTodas();
}
