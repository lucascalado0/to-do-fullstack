package com.example.to_do_fullstack.exception;

public class TarefaNotFoundException extends RuntimeException {
    public TarefaNotFoundException(String message) {
        super(message);
    }
}
