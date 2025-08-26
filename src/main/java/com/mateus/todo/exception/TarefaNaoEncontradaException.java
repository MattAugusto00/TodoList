package com.mateus.todo.exception;

public class TarefaNaoEncontradaException extends RuntimeException {

    public TarefaNaoEncontradaException(){
        super("Tarefa não encontrada.");
    }

    public TarefaNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
