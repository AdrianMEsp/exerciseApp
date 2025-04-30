package com.example.ExerciseApp.exerciseApp.controller;

import com.example.ExerciseApp.exerciseApp.model.request.ExerciseDto;
import com.example.ExerciseApp.exerciseApp.model.response.ExerciseResponse;
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
import java.util.Arrays;

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

    @Test
    @DisplayName("Test delete existing exercise by id")
    void testDeleteExistingExerciseById() throws Exception{
        Long exerciseId = 1L;
        when(exerciseService.deleteExerciseById(eq(exerciseId)))
                .thenReturn(true);

        mockMvc.perform(delete("/api/v1/exercise/id/{id}",exerciseId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(exerciseService,times(1))
        .deleteExerciseById(eq(exerciseId));
    }

    @Test
    @DisplayName("Test delete NOT existing exercise by id")
    void testDeleteNotExistingExerciseById() throws Exception{
        Long exerciseId = 1L;
        when(exerciseService.deleteExerciseById(eq(exerciseId)))
                .thenReturn(false);

        mockMvc.perform(delete("/api/v1/exercise/id/{id}",exerciseId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(exerciseService,times(1))
                .deleteExerciseById(eq(exerciseId));
    }

    @Test
    @DisplayName("Test delete existing exercise by name")
    void testDeleteExistingExerciseByName() throws Exception{
        String exerciseName = "Burpees";
        when(exerciseService.deleteExerciseByName(eq(exerciseName)))
                .thenReturn(true);

        mockMvc.perform(delete("/api/v1/exercise/name/{name}",exerciseName)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(exerciseService,times(1))
                .deleteExerciseByName(eq(exerciseName));
    }

    @Test
    @DisplayName("Test delete NOT existing exercise by name")
    void testDeleteNotExistingExerciseByName() throws Exception{
        String exerciseName = "Burpees";
        when(exerciseService.deleteExerciseByName(eq(exerciseName)))
                .thenReturn(false);

        mockMvc.perform(delete("/api/v1/exercise/name/{name}",exerciseName)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

        verify(exerciseService,times(1))
                .deleteExerciseByName(eq(exerciseName));
    }

    @Test
    @DisplayName("Test get all exercises WITH exercises")
    void testGetAllExercise() throws Exception{
        ExerciseResponse exe1 = new ExerciseResponse("Run",1,6000);
        ExerciseResponse exe2 = new ExerciseResponse("Bicycle",1,3000);

        when(exerciseService.getAllExercises())
                .thenReturn(Arrays.asList(exe1,exe2));

        mockMvc.perform(get("/api/v1/exercise")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name")
                        .value(exe1.getName()));

        verify(exerciseService,times(1))
                .getAllExercises();
    }

    @Test
    @DisplayName("Test get all exercises WITHOUT exercises")
    void testGetAllExerciseEmpty() throws Exception{

        when(exerciseService.getAllExercises())
                .thenReturn(null);

        mockMvc.perform(get("/api/v1/exercise")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(exerciseService,times(1))
                .getAllExercises();
    }


}
