package org.ramg.store.mapper;

import org.ramg.store.dto.UserDto;
import org.ramg.store.entity.User;
public class UserMapper {
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getStore(),
                user.getAddress(),
                user.getContact(),
                user.getEmail(),
                user.getPassword()
        );
    }
    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getStore(),
                userDto.getAddress(),
                userDto.getContact(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

}
