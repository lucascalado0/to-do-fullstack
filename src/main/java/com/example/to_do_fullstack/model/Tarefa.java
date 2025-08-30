package com.example.to_do_fullstack.model;

import com.example.to_do_fullstack.model.enums.Status;
import com.google.gson.Gson;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "tarefas")
@Entity
@Getter
@Setter
public class Tarefa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Id
    private Long id;

    @Column(name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tarefa(Long id, String descricao, Status status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public Tarefa(){
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
