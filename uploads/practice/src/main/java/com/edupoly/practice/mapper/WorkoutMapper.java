package com.edupoly.practice.mapper;

import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.Workout;

public class WorkoutMapper {
    public static WorkoutDto mapToWorkoutDto(Workout workout){
        WorkoutDto workoutDto=new WorkoutDto(
                workout.getId(),
                workout.getDay(),
                workout.getCategory(),
                workout.getWorkout(),
                workout.getSets(),
                workout.getRepetitions()
        );
        return  workoutDto;
    }
    public static Workout mapToWorkout(WorkoutDto workoutDto){
        Workout workout=new Workout(
                workoutDto.getId(),
                workoutDto.getDay(),
                workoutDto.getCategory(),
                workoutDto.getWorkout(),
                workoutDto.getSets(),
                workoutDto.getRepetitions()
        );
        return  workout;
    }

}
