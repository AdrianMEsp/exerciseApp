package com.example.ExerciseApp.exerciseApp.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExerciseResponse {
    private String name;
    private int series;
    private int repetitionsOrSeconds;
    private double weight;
    private String description;

    public ExerciseResponse() {
    }

    public ExerciseResponse(String name, int series, int repetitionsOrSeconds, double weight) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
    }

    public ExerciseResponse(String name, int series, int repetitionsOrSeconds, double weight, String description) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
        this.description = description;
    }
}
