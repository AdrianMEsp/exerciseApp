package com.example.ExerciseApp.exerciseApp.exceptions;

public class ExerciseNotFoundId extends RuntimeException {
    public ExerciseNotFoundId(Long id) {
        super("Exercise with ID "+id+" not found - timeout ");
    }
}
