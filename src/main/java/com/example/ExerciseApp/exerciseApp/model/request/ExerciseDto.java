package com.example.ExerciseApp.exerciseApp.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ExerciseDto {
    private String name;
    private int series;
    private int repetitionsOrSeconds;

    public ExerciseDto(String name, int series, int repetitionsOrSeconds) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
    }
}
