package com.example.ExerciseApp.exerciseApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int series;
    private int repetitionsOrSeconds;
    private double weight;
    private String description;

    public Exercise() {
    }

    //TODO: cambiar para que el constructor sea uno solo, que en caso de no recibir descripcion, cree una vacia
    // eso hace que cambie tambien el ServiceImpl ya que no debo analizar si es null
    public Exercise(String name, int series, int repetitionsOrSeconds, double weight) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
    }

    public Exercise(String name, int series, int repetitionsOrSeconds, double weight, String description) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
        this.description = description;
    }
}
