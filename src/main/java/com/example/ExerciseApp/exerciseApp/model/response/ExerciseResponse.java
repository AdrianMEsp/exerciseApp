package com.example.ExerciseApp.exerciseApp.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class ExerciseResponse {
    private String name;
    private int series;
    private int repetitionsOrSeconds;
    private double weight;

    public ExerciseResponse(String name, int series, int repetitionsOrSeconds, double weight) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
    }
}
