package com.mateus.todo.controller;


import com.mateus.todo.dto.TaskRequest;
import com.mateus.todo.dto.TaskResponse;
import com.mateus.todo.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @Operation(description = "Salva novas tarefas no banco de dados.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Requisição aceita. Tarefa foi salva com sucesso no banco."),
            @ApiResponse(responseCode = "409", description = "Requisição falhou. Já existe uma tarefa com este titulo nesta mesma data."),
            @ApiResponse(responseCode = "400", description = "Requisição falhou. Tentativa de criação sem um dos campos necessarios.")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse salvar(@RequestBody @Valid TaskRequest taskRequest){
        return taskService.salvar(taskRequest);
    }

    @Operation(description = "Lista todas as tarefas que estão salvas no banco.")
    @ApiResponse(responseCode = "200", description = "Foram retornadas todas as tarefas salvas.")
    @GetMapping
    public ResponseEntity<List<TaskResponse>> listarTodas(){
        List<TaskResponse> tasks = taskService.listarTodas();
        return ResponseEntity.ok(tasks);
    }

    @Operation(description = "Atualiza a tarefa com o ID selecionado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A tarefa foi atualizada."),
            @ApiResponse(responseCode = "400", description = "Requisição falhou. Tentativa de atualização sem um dos campos necessarios.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> atualizar(@PathVariable UUID id, @RequestBody @Valid TaskRequest taskRequest){
        TaskResponse atualizado = taskService.atualizar(id, taskRequest);

        return ResponseEntity.ok(atualizado);
    }

    @Operation(description = "Deleta a tarefa de ID selecionado.")
    @ApiResponse(responseCode = "204", description = "Tarefa removida com sucesso. Nenhum conteúdo retornado.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id){
        taskService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
