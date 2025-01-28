package com.edupoly.practice.service.impl;

import com.edupoly.practice.dto.UserDto;
import com.edupoly.practice.dto.WorkoutDto;
import com.edupoly.practice.entity.Workout;
import com.edupoly.practice.mapper.UserMapper;
import com.edupoly.practice.mapper.WorkoutMapper;
import com.edupoly.practice.repository.UserRepository;
import com.edupoly.practice.repository.WorkoutRepository;
import com.edupoly.practice.service.UserService;
import com.edupoly.practice.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    private WorkoutRepository workoutRepository;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    @Override
    public List<WorkoutDto> getAllWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();
        List<WorkoutDto> workoutDto = workouts.stream()
                .map((workout)-> WorkoutMapper.mapToWorkoutDto(workout))
                .collect(Collectors.toList());
        return  workoutDto;
    }
//    @Override
//    public void authenticate(UserDto userDto) {
//        System.out.println(userDto.getEmail());
////        User user = userRepository.findByUserName(userDto.getEmail());
////        List<UserDto> userDto = users.stream()
////                .map((user)-> UserMapper.mapToUserDto(user))
////                .collect(Collectors.toList());
////        return  userDto;
//    }
    @Override
    public void createWorkout(WorkoutDto workoutDto){

    }

    @Override
    public void deleteWorkoutById(Long id) {

    }

    @Override
    public void addWorkout(WorkoutDto workoutDto) {
        Workout workout = WorkoutMapper.mapToWorkout(workoutDto);
        workoutRepository.save(workout);
    }

//    @Override
//    public List<WorkoutDto> getWorkoutsByDay() {
//        return null;
//    }

    @Override
    public Workout[] getWorkoutsByDay(String s1) {
        System.out.println("get workoutsbyday");

        return workoutRepository.findByDay(s1);
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
