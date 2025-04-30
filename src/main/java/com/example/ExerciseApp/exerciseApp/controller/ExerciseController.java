package com.example.ExerciseApp.exerciseApp.controller;

import com.example.ExerciseApp.exerciseApp.exceptions.ExerciseNotFoundId;
import com.example.ExerciseApp.exerciseApp.exceptions.ExerciseNotFoundName;
import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.model.response.ExerciseResponse;
import com.example.ExerciseApp.exerciseApp.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteExerciseByName(@PathVariable String name){
        try{
            boolean deleted = this.exerciseService.deleteExerciseByName(name);
            if (! deleted){
                return ResponseEntity.notFound().build();
            }
            log.info("Exercise {} deleted",name);
            return ResponseEntity.ok().build();
        }catch (ExerciseNotFoundName e){
            throw new ExerciseNotFoundName(name);
        }
    }

    @GetMapping
    public List<ExerciseResponse> getAllExercises(){
        try{
            List<ExerciseResponse> exercises = this.exerciseService.getAllExercises();
            if (exercises != null) {
                log.info("Found {} exercises", exercises.size());
                return exercises;
            }
            return null;
        }catch (Exception e){
            log.error("Error obtaining exercises ");
            throw e;
        }
    }

    @GetMapping("/{name}")
    public ExerciseResponse getExerciseByName(@PathVariable String name){
        try{
            return this.exerciseService.getExerciseByName(name);
        }catch (Exception e){
            log.error("Error obtaining exercise {}",name);
            throw e;
        }
    }

    @PutMapping("/{name}")
    public ResponseEntity<Void> updateExerciseByName(@PathVariable String name,
                                                     @RequestBody ExerciseDto modifiedExercise){
        try {
            if (this.exerciseService.updateExerciseByName(name,modifiedExercise) != null){
                return ResponseEntity.ok().build();
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
