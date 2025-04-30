package com.example.ExerciseApp.exerciseApp.service;

import com.example.ExerciseApp.exerciseApp.model.Exercise;
import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.model.response.ExerciseResponse;

import java.util.List;
import java.util.Optional;

public interface ExerciseService {

    void addExercise(ExerciseDto exerciseDto);

    ExerciseResponse getExerciseById(Long id);

    boolean deleteExerciseById(Long id);

    boolean deleteExerciseByName(String name);

    List<ExerciseResponse> getAllExercises();

    ExerciseResponse updateExerciseByName(String name, ExerciseDto modifiedExercise);

    ExerciseResponse getExerciseByName(String name);
}
