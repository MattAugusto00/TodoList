package com.mateus.todo.mapper;

import com.mateus.todo.dto.TaskRequest;
import com.mateus.todo.dto.TaskResponse;
import com.mateus.todo.enums.StatusTarefa;
import com.mateus.todo.model.Task;

public class TaskMapper {
    public static Task toEntity(TaskRequest taskRequest){
        Task task = new Task();
        task.setTitulo(taskRequest.titulo());
        task.setDescricao(taskRequest.descricao());
        task.setDataVencimento(taskRequest.dataVencimento());
        task.setStatusTarefa(StatusTarefa.PENDENTE);

        return task;
    }

    public static TaskResponse toResponse(Task task){
        return new TaskResponse(
                task.getUuid(),
                task.getTitulo(),
                task.getDescricao(),
                task.getStatusTarefa(),
                task.getDataCriacao(),
                task.getDataVencimento()
        );
    }
}
