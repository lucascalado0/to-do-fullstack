package com.example.to_do_fullstack.controller;

import com.example.to_do_fullstack.dto.TarefaDTO;
import com.example.to_do_fullstack.entity.Tarefa;
import com.example.to_do_fullstack.mapper.TarefaMapper;
import com.example.to_do_fullstack.service.TarefaService;
import com.example.to_do_fullstack.service.impl.TarefaServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {


    private final TarefaService tarefaService;
    private final TarefaMapper tarefaMapper;

    public TarefaController(TarefaService tarefaService, TarefaMapper tarefaMapper) {
        this.tarefaService = tarefaService;
        this.tarefaMapper = tarefaMapper;
    }


    @PostMapping
    public ResponseEntity<TarefaDTO> criarTarefa(@Valid @RequestBody TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);

        return ResponseEntity.ok().body(tarefaMapper.toDTO(novaTarefa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> buscarPorId(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(tarefa -> ResponseEntity.ok(tarefaMapper.toDTO(tarefa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listar-todas")
    public List<TarefaDTO> listarTodas() {

        return tarefaMapper.toDTOList(tarefaService.listarTodas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizarTarefa(@PathVariable Long id, @RequestBody @Valid TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        return tarefaService.atualizarTarefa(id, tarefa)
                .map(t -> ResponseEntity.ok(tarefaMapper.toDTO(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}