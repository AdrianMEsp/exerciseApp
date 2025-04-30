package com.example.ExerciseApp.exerciseApp.controller;

import com.example.ExerciseApp.exerciseApp.exceptions.ExerciseNotFoundId;
import com.example.ExerciseApp.exerciseApp.model.Exercise;
import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.model.response.ExerciseResponse;
import com.example.ExerciseApp.exerciseApp.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/exercise")
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseService exerciseService;

    @PostMapping("/add")
    public HttpStatus addExercise(@RequestBody ExerciseDto exerciseDto){
        try{
            exerciseService.addExercise(exerciseDto);
            return HttpStatus.CREATED;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteExerciseById(@PathVariable Long id){
        try{
            boolean deleted = this.exerciseService.deleteExerciseById(id);
            if (! deleted){
                return ResponseEntity.notFound().build();
            }
            log.info("Exercise with id: {} deleted",id);
            return ResponseEntity.ok().build();
        } catch (ExerciseNotFoundId e) {
            throw new ExerciseNotFoundId(id);
        }
    }
}
