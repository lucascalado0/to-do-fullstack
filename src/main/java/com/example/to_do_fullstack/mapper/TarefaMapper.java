package com.example.to_do_fullstack.mapper;


import com.example.to_do_fullstack.dto.TarefaDTO;
import com.example.to_do_fullstack.entity.Tarefa;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface TarefaMapper {

    TarefaDTO toDTO(Tarefa tarefa);

    Tarefa toEntity(TarefaDTO tarefaDTO);

    List<TarefaDTO> toDTOList(List<Tarefa> tarefas);
}
