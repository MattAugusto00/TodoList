package com.mateus.todo.service;

import com.mateus.todo.dto.TaskRequest;
import com.mateus.todo.dto.TaskResponse;
import com.mateus.todo.mapper.TaskMapper;
import com.mateus.todo.model.Task;
import com.mateus.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;

    @Transactional
    public TaskResponse salvar(TaskRequest taskRequest){
        boolean existe = repository.findByTituloAndDataVencimento(taskRequest.titulo(),taskRequest.dataVencimento())
                .stream()
                .findAny()
                .isPresent();

        if (existe){
            throw new RuntimeException("Já existe uma tarefa com este titulo para esta data.");
        }

        Task task = TaskMapper.toEntity(taskRequest);

        Task salvo = repository.save(task);

        return TaskMapper.toResponse(salvo);
    }

}