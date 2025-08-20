package com.mateus.todo.controller;


import com.mateus.todo.dto.TaskRequest;
import com.mateus.todo.dto.TaskResponse;
import com.mateus.todo.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse salvar(@RequestBody @Valid TaskRequest taskRequest){
        return taskService.salvar(taskRequest);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> listarTodas(){
        List<TaskResponse> tasks = taskService.listarTodas();
        return ResponseEntity.ok(tasks);
    }
}
