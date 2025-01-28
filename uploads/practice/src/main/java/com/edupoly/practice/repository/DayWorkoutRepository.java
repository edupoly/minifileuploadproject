package com.edupoly.practice.repository;

import com.edupoly.practice.entity.DayWorkout;
import com.edupoly.practice.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayWorkoutRepository extends JpaRepository<DayWorkout,Long> {
    DayWorkout[] findByDay(String day1);

    DayWorkout[] findByEmail(String email);
}
