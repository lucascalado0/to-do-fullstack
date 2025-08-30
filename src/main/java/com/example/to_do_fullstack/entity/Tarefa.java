package com.example.to_do_fullstack.entity;

import com.example.to_do_fullstack.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "tarefas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Getter
@Setter
public class Tarefa {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @Id
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Tarefa(String titulo, String descricao, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
    }
}
