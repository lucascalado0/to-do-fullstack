package com.example.to_do_fullstack.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class TarefaDTO {

    private Long id;

    @NotBlank(message = "O título não pode ser vazio")
    @Size(max = 255, message = "O título deve ter no máximo 50 caracteres.")
    private String titulo;

    @NotBlank(message = "A descrição não pode ser vazia")
    private String descricao;

    @NotNull(message = "O status não pode ser nulo")
    private String status;

    @Override
    public String toString() {
        return "TarefaDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
