package com.mateus.todo.dto;

import com.mateus.todo.enums.StatusTarefa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskResponse(
        UUID id,
        String titulo,
        String descricao,
        StatusTarefa statusTarefa,
        LocalDateTime dataCriacao,
        LocalDate dataVencimento
) {
}
