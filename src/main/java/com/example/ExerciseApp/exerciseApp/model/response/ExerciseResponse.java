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

    public ExerciseResponse(String name, int series, int repetitionsOrSeconds) {
        this.name = name;
        this.series = series;
        this.repetitionsOrSeconds = repetitionsOrSeconds;
    }
}
