package com.example.ExerciseApp.exerciseApp.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExerciseResponse {
    private String name;
    private String series;
    private int repetitionsOrMinutes;
    private double weight;
    private String description;

    public ExerciseResponse() {
    }

    public ExerciseResponse(String name, String series, int repetitionsOrMinutes, double weight) {
        this.name = name;
        this.series = series;
        this.repetitionsOrMinutes = repetitionsOrMinutes;
        this.weight = weight;
    }

    public ExerciseResponse(String name, String series, int repetitionsOrMinutes, double weight, String description) {
        this.name = name;
        this.series = series;
        this.repetitionsOrMinutes = repetitionsOrMinutes;
        this.weight = weight;
        this.description = description;
    }
}
