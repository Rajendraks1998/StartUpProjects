package org.ramg.store.service.impl;

import org.modelmapper.ModelMapper;
import org.ramg.store.constants.ConstantsEnum;
import org.ramg.store.dto.UserDto;
import org.ramg.store.entity.User;
import org.ramg.store.exception.ResourceNotFoundException;
import org.ramg.store.repository.UserRepository;
import org.ramg.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
//        User user = UserMapper.mapToUser(userDto);
        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
//        return UserMapper.mapToUserDto(savedUser);
        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException(ConstantsEnum.USER_NOT_EXISTS.getValue()+userId)
        );
//        return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(ConstantsEnum.USER_NOT_EXISTS.getValue() + userId)
        );
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(ConstantsEnum.USER_NOT_EXISTS.getValue()+ userId)
        );
        user.setName(updatedUser.getName());
        user.setStore(updatedUser.getStore());
        user.setAddress(updatedUser.getAddress());
        user.setContact(updatedUser.getContact());
        user.setEmail(updatedUser.getEmail());
        userRepository.save(user);
//        return UserMapper.mapToUserDto(user);
        return modelMapper.map(user, UserDto.class);
    }
}
