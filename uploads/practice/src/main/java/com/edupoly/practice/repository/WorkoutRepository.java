package com.edupoly.practice.repository;

import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {
    Workout[] findByDay(String day1);
}
