package com.edupoly.practice.service;

import com.edupoly.practice.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    void createUser(UserDto user);
    void deleteUserById(Long id);

    Boolean authenticate(UserDto user);

}
