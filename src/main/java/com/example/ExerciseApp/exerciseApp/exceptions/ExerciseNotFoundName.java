package com.example.ExerciseApp.exerciseApp.exceptions;

public class ExerciseNotFoundName extends RuntimeException {
    public ExerciseNotFoundName(String name) {
      super("Exercise with ID "+name+" not found - timeout ");
    }
}
