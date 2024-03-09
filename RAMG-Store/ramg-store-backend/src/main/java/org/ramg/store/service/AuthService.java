package org.ramg.store.service;


import org.ramg.store.dto.LoginDto;
import org.ramg.store.dto.UserDto;

public interface AuthService {
    String register(UserDto registerDto);

    String login(LoginDto loginDto);
}
