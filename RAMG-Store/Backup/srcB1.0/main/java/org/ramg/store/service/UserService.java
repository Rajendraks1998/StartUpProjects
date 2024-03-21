package org.ramg.store.service;

import org.ramg.store.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUserById(Long userId);
    UserDto updateUser(Long userId, UserDto userDto);
}
