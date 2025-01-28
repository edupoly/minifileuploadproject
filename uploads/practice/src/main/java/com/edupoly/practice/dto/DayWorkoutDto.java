package com.edupoly.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DayWorkoutDto {
    public Long id;
    public String day;
    public String category;
    public String date;
    public String email;
    public String workout;
    public int sets;
    public int repetitions;
}
