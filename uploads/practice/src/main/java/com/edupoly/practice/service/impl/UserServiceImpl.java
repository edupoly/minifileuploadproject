package com.edupoly.practice.service.impl;

import com.edupoly.practice.dto.EmployeeDto;
import com.edupoly.practice.entity.User;
import com.edupoly.practice.mapper.EmployeeMapper;
import com.edupoly.practice.mapper.UserMapper;
import com.edupoly.practice.repository.EmployeeRepository;
import com.edupoly.practice.repository.UserRepository;
import com.edupoly.practice.service.EmployeeService;
import com.edupoly.practice.service.UserService;
import org.springframework.stereotype.Service;
import  com.edupoly.practice.dto.UserDto;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
//    public void createEmployee(EmployeeDto employeeDto) {
//        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
//        employeeRepository.save(employee);
//    }
    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = users.stream()
                .map((user)-> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
        return  userDto;
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
    public void createUser(UserDto userDto){
        System.out.println("User Service Impl DTO::"+userDto.getPassword());
        User user = UserMapper.mapToUser(userDto);
        System.out.println("User Service Impl::"+user.getPassword());
        userRepository.save(user);
    }
    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public Boolean authenticate(UserDto user) {
        try{
            User isUser = userRepository.findByEmail(user.getEmail());
            if(isUser.getPassword().equals((user.getPassword()))){

                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }
}
