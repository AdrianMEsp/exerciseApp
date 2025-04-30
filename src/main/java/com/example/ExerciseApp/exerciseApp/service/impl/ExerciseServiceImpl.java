package com.example.ExerciseApp.exerciseApp.service.impl;

import com.example.ExerciseApp.exerciseApp.exceptions.ExerciseNotFoundName;
import com.example.ExerciseApp.exerciseApp.model.Exercise;
import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.model.response.ExerciseResponse;
import com.example.ExerciseApp.exerciseApp.repository.ExerciseRepository;
import com.example.ExerciseApp.exerciseApp.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                exerciseDto.getRepetitionsOrSeconds(),
                exerciseDto.getWeight());
        this.exerciseRepository.save(exercise);
    }

    @Override
    public ExerciseResponse getExerciseById(Long id){
        Optional<Exercise> found = this.exerciseRepository.findById(id);
        if (found.isPresent()){
            return mapToResponse(found.get());
        }
        return null;
    }

    @Override
    public boolean deleteExerciseById(Long id){
        ExerciseResponse exerciseResponse = getExerciseById(id);
        if (exerciseResponse != null){
            this.exerciseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Exercise getExerciseByName(String name){
        return this.exerciseRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ExerciseNotFoundName(name));
    }

    @Override
    public boolean deleteExerciseByName(String name){
        Exercise exercise = getExerciseByName(name);
        if (exercise != null) {
            this.exerciseRepository.deleteById(exercise.getId());
            return true;
        }
        return false;
    }

    @Override
    public List<ExerciseResponse> getAllExercises(){
        return this.exerciseRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ExerciseResponse updateExerciseByName(String name, ExerciseDto modifiedExercise){
        Exercise found = this.exerciseRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new ExerciseNotFoundName(name));

            found.setName(modifiedExercise.getName());
            found.setSeries(modifiedExercise.getSeries());
            found.setRepetitionsOrSeconds(modifiedExercise.getRepetitionsOrSeconds());
            found.setWeight(modifiedExercise.getWeight());
            this.exerciseRepository.save(found);
            return mapToResponse(found);

    }


    private ExerciseResponse mapToResponse(Exercise exercise){
        return new ExerciseResponse(
                exercise.getName(),
                exercise.getSeries(),
                exercise.getRepetitionsOrSeconds(),
                exercise.getWeight()
        );
    }

}
