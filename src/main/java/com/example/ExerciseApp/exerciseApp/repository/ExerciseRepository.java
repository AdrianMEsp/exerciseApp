package com.example.ExerciseApp.exerciseApp.repository;

import com.example.ExerciseApp.exerciseApp.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
