package com.example.ExerciseApp.exerciseApp.service.impl;

import com.example.ExerciseApp.exerciseApp.model.Exercise;
import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.repository.ExerciseRepository;
import com.example.ExerciseApp.exerciseApp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl (ExerciseRepository exerciseRepository){
        this.exerciseRepository=exerciseRepository;
    }

    @Override
    public void addExercise(ExerciseDto exerciseDto) {
        Exercise exercise = new Exercise(exerciseDto.getName(),
                exerciseDto.getSeries(),
                exerciseDto.getRepetitionsOrSeconds());
        this.exerciseRepository.save(exercise);
    }
}
