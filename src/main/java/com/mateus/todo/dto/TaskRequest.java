package com.mateus.todo.dto;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TaskRequest(
    @NotBlank(message = "O titulo é obrigatório.")
    String titulo,
    String descricao,
    @NotBlank(message = "A data de vencimento é obrigatória.")
    LocalDate dataVencimento
) {
}