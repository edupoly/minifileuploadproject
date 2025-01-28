package com.edupoly.practice.mapper;

import com.edupoly.practice.dto.UserDto;
import com.edupoly.practice.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user){
        UserDto userDto=new UserDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getMobile(),
                user.getPassword(),
                user.getRole(),
                user.getAge(),
                user.getGender(),
                user.getHeight(),
                user.getWeight(),
                user.isLooseWeight(),
                user.isGainWeight(),
                user.isGainMuscle(),
                user.isCalorieBurning(),
                user.isTonedBody(),
                user.isDietControl()
        );
        return  userDto;
    }

    public static User mapToUser(UserDto userDto){
        User user=new User(
                userDto.getId(),
                userDto.getFullName(),
                userDto.getEmail(),
                userDto.getMobile(),
                userDto.getPassword(),
                userDto.getRole(),
                userDto.getAge(),
                userDto.getGender(),
                userDto.getHeight(),
                userDto.getWeight(),
                userDto.isLooseWeight(),
                userDto.isGainWeight(),
                userDto.isGainMuscle(),
                userDto.isCalorieBurning(),
                userDto.isTonedBody(),
                userDto.isDietControl()
        );
        return  user;
    }
}
