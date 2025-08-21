package com.mateus.todo.service;

import com.mateus.todo.dto.TaskRequest;
import com.mateus.todo.dto.TaskResponse;
import com.mateus.todo.mapper.TaskMapper;
import com.mateus.todo.model.Task;
import com.mateus.todo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    public List<TaskResponse> listarTodas(){
        return repository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    public TaskResponse atualizar(UUID id, TaskRequest taskRequest){
        Task task = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Tarefa não encontrada!")
        );

        task.setTitulo(taskRequest.titulo());
        task.setDescricao(taskRequest.descricao());
        task.setDataVencimento(taskRequest.dataVencimento());

        if (taskRequest.statusTarefa() != null){
            task.setStatusTarefa(taskRequest.statusTarefa());
        }

        Task atualizado = repository.save(task);

        return TaskMapper.toResponse(atualizado);
    }

}