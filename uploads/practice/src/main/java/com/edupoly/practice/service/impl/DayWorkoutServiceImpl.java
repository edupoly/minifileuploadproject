package com.edupoly.practice.service.impl;

import com.edupoly.practice.dto.DayWorkoutDto;
import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.DayWorkout;
import com.edupoly.practice.entity.Employee;
import com.edupoly.practice.entity.Workout;
import com.edupoly.practice.mapper.DayWorkoutMapper;
import com.edupoly.practice.mapper.EmployeeMapper;
import com.edupoly.practice.mapper.WorkoutMapper;
import com.edupoly.practice.repository.DayWorkoutRepository;
import com.edupoly.practice.repository.WorkoutRepository;
import com.edupoly.practice.service.DayWorkoutService;
import com.edupoly.practice.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayWorkoutServiceImpl implements DayWorkoutService {
    private DayWorkoutRepository dayWorkoutRepository;

    public DayWorkoutServiceImpl(DayWorkoutRepository dayWorkoutRepository) {
        this.dayWorkoutRepository = dayWorkoutRepository;
    }

    @Override
    public List<DayWorkoutDto> getAllDayWorkouts() {
        return null;
    }

    @Override
    public void createDayWorkout(DayWorkoutDto dayWorkoutDto) {
        DayWorkout dayWorkout = DayWorkoutMapper.mapToDayWorkout(dayWorkoutDto);
        dayWorkoutRepository.save(dayWorkout);
    }

    @Override
    public void deleteDayWorkoutById(Long id) {

    }

    @Override
    public void addDayWorkout(DayWorkoutDto dayWorkoutDto) {
        DayWorkout dayWorkout = DayWorkoutMapper.mapToDayWorkout(dayWorkoutDto);
        dayWorkoutRepository.save(dayWorkout);
    }

    @Override
    public DayWorkout[] getDayWorkoutsByDay() {
        return new DayWorkout[0];
    }

    @Override
    public DayWorkout[] getDayWorkoutsByEmail(String email) {
        DayWorkout[] dayWorkouts = dayWorkoutRepository.findByEmail(email);
        return dayWorkouts;
    }
//    @Override
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//    @Override
//    public Boolean authenticate(UserDto user) {
//        try{
//            User isUser = userRepository.findByEmail(user.getEmail());
//            if(isUser.getPassword().equals((user.getPassword()))){
//                return true;
//            }
//            else{
//                return false;
//            }
//        }
//        catch(Exception e){
//            return false;
//        }
//    }
}
