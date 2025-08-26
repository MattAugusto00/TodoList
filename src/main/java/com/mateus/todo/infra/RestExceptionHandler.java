package com.mateus.todo.infra;

import com.mateus.todo.exception.TarefaJaExistenteNaDataException;
import com.mateus.todo.exception.TarefaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TarefaJaExistenteNaDataException.class)
    private ResponseEntity<RestErrorMessage> tarefaJaExistenteNaDataHandler(TarefaJaExistenteNaDataException exception){
        RestErrorMessage treatedResponse = new RestErrorMessage(HttpStatus.CONFLICT, exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(treatedResponse);
    }

    @ExceptionHandler(TarefaNaoEncontradaException.class)
    private ResponseEntity<RestErrorMessage> tarefaNaoEncontradaHandler(TarefaNaoEncontradaException exception){

        RestErrorMessage treatedResponse = new RestErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(treatedResponse);
    }
}