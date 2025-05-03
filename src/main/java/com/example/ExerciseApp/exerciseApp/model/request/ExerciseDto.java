package com.example.ExerciseApp.exerciseApp.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ExerciseDto {
    private String name;
    private String series;
    private int repetitionsOrSeconds;
    private double weight;
    private String description;

    public ExerciseDto() {
    }

    public ExerciseDto(String name, String series, int repetitionsOrSeconds, double weight) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
    }

    public ExerciseDto(String name, String series, int repetitionsOrSeconds, double weight, String description) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
        this.weight = weight;
        this.description = description;
    }
}
