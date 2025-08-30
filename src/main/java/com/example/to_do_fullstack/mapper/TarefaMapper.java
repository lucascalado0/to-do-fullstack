package com.example.to_do_fullstack.mapper;


import com.example.to_do_fullstack.dto.TarefaDTO;
import com.example.to_do_fullstack.entity.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TarefaMapper {
    TarefaMapper INSTANCE = Mappers.getMapper(TarefaMapper.class);

    TarefaDTO toDTO(Tarefa tarefa);

    Tarefa toEntity(TarefaDTO tarefaDTO);
}
