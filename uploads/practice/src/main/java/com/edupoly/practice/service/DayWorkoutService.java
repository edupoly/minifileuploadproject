package com.edupoly.practice.service;

import com.edupoly.practice.dto.DayWorkoutDto;
import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.DayWorkout;
import com.edupoly.practice.entity.Workout;

import java.util.List;

public interface DayWorkoutService {
    List<DayWorkoutDto> getAllDayWorkouts();
    void createDayWorkout(DayWorkoutDto dayWorkoutDto);
    void deleteDayWorkoutById(Long id);

    void addDayWorkout(DayWorkoutDto dayWorkoutDto);

    DayWorkout[] getDayWorkoutsByDay();

    DayWorkout[] getDayWorkoutsByEmail(String email);
}
