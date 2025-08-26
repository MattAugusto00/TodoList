package com.mateus.todo.exception;


//Exception para identificar que a tarefa já existe na mesma data, portanto, não pode ser adicionada novamente
public class TarefaJaExistenteNaDataException extends RuntimeException{

    public TarefaJaExistenteNaDataException(){
        super("Já existe uma tarefa com este titulo para esta data.");
    }

    public TarefaJaExistenteNaDataException(String mensagem){
        super(mensagem);
    }
}
