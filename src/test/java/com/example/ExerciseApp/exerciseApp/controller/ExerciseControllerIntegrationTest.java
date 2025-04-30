package com.example.ExerciseApp.exerciseApp.controller;

import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.service.ExerciseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ExerciseControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockitoBean
    private ExerciseService exerciseService;
    private ExerciseDto exercise;

    @BeforeEach
    void setUp(){
        exercise = new ExerciseDto("Burpees",3,15);
    }

    @Test
    @DisplayName("Test add exercise")
    void testAddExercise() throws Exception {
        doNothing().when(exerciseService).addExercise(any(ExerciseDto.class));

        mockMvc.perform(post("/api/v1/exercise/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(exercise)))
                .andExpect(status().isOk());

        verify(exerciseService,times(1))
                .addExercise(any(ExerciseDto.class));
    }

}
