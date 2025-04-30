package com.example.ExerciseApp.exerciseApp.service;

import com.example.ExerciseApp.exerciseApp.model.Exercise;
import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.model.response.ExerciseResponse;

import java.util.Optional;

public interface ExerciseService {

    void addExercise(ExerciseDto exerciseDto);

    ExerciseResponse getExerciseById(Long id);

    boolean deleteExerciseById(Long id);
}
