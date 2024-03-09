package org.ramg.store.service.impl;

import lombok.AllArgsConstructor;
import org.ramg.store.dto.LoginDto;
import org.ramg.store.dto.UserDto;
import org.ramg.store.entity.Role;
import org.ramg.store.entity.User;
import org.ramg.store.exception.RAMGStoreAPIException;
import org.ramg.store.repository.RoleRepository;
import org.ramg.store.repository.UserRepository;
import org.ramg.store.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    @Override
    public String register(UserDto userDto) {

        // check username is already exists in database
        if(userRepository.existsByUsername(userDto.getUsername())){
            throw new RAMGStoreAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
        }

        // check email is already exists in database
        if(userRepository.existsByEmail(userDto.getEmail())){
            throw new RAMGStoreAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(userDto.getName());
        user.setStore(userDto.getStore());
        user.setAddress(userDto.getAddress());
        user.setContact(userDto.getContact());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);
        userRepository.save(user);
        return "User Registered Successfully!.";
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(),
                loginDto.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User logged-in successfully!.";
    }
}
