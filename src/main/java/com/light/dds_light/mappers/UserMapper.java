package com.light.dds_light.mappers;

import com.light.dds_light.dto.request.CreateUserRequest;
import com.light.dds_light.dto.response.UserResponse;
import com.light.dds_light.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User toEntity(CreateUserRequest request) {
        return new User(
                null,
                request.nome(),
                request.email(),
                request.senha());
    }

    public static UserResponse toDto(User user) {
        return new UserResponse(
                user.getNome(),
                user.getEmail());
    }
}
