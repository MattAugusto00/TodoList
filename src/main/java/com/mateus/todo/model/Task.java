package com.mateus.todo.model;

import com.mateus.todo.enums.StatusTarefa;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa statusTarefa;

    private LocalDateTime dataCriacao;

    private LocalDate dataVencimento;

    private LocalDateTime dataConclusao;

    @PrePersist
    public void salvarDataCriacao(){
        this.dataCriacao = LocalDateTime.now();
    }
}
