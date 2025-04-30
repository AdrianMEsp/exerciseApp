package com.example.ExerciseApp.exerciseApp.controller;

import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/add")
    public void addExercise(@RequestBody ExerciseDto exerciseDto){
        try{
            exerciseService.addExercise(exerciseDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
