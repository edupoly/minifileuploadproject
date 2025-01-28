package com.edupoly.practice.service;

import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.Workout;

import java.util.List;

public interface WorkoutService {
    List<WorkoutDto> getAllWorkouts();
    void createWorkout(WorkoutDto workoutDto);
    void deleteWorkoutById(Long id);

    void addWorkout(WorkoutDto workout);

    Workout[] getWorkoutsByDay(String s1);
}
