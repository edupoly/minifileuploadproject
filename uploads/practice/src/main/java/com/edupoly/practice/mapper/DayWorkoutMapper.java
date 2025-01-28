package com.edupoly.practice.mapper;

import com.edupoly.practice.dto.DayWorkoutDto;
import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.DayWorkout;
import com.edupoly.practice.entity.Workout;

public class DayWorkoutMapper {
    public static DayWorkoutDto mapToDayWorkoutDto(DayWorkout dayWorkout){
        DayWorkoutDto dayWorkoutDto = new DayWorkoutDto(
                dayWorkout.getId(),
                dayWorkout.getDay(),
                dayWorkout.getCategory(),
                dayWorkout.getDate(),
                dayWorkout.getEmail(),
                dayWorkout.getWorkout(),
                dayWorkout.getSets(),
                dayWorkout.getRepetitions()
        );
        return  dayWorkoutDto;
    }
    public static DayWorkout mapToDayWorkout(DayWorkoutDto dayWorkoutDto){
        DayWorkout dayWorkout=new DayWorkout(
                dayWorkoutDto.getId(),
                dayWorkoutDto.getDay(),
                dayWorkoutDto.getCategory(),
                dayWorkoutDto.getDate(),
                dayWorkoutDto.getEmail(),
                dayWorkoutDto.getWorkout(),
                dayWorkoutDto.getSets(),
                dayWorkoutDto.getRepetitions()
        );
        return  dayWorkout;
    }

}
