package com.light.dds_light.service;

import com.light.dds_light.dto.request.CreateUserRequest;
import com.light.dds_light.dto.response.UserResponse;
import com.light.dds_light.entities.User;
import com.light.dds_light.exceptions.UsernameOrPasswordInvalidException;
import com.light.dds_light.mappers.UserMapper;
import com.light.dds_light.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

    public UserResponse register(CreateUserRequest request) {
        User user = UserMapper.toEntity(request);
        if(request.email().contains(user.getEmail())) {
            throw new UsernameOrPasswordInvalidException("Email existente, tente outro válido.");
        }
        user.setSenha(passwordEncoder.encode(request.senha()));
        return UserMapper.toDto(repository.save(user));
    }
}


