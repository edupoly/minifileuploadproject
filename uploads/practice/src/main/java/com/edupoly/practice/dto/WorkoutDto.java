package com.edupoly.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutDto {
    public Long id;
    public String day;
    public String category;
    public String workout;
    public int sets;
    public int repetitions;
}
