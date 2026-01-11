package com.light.dds_light.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequest(
        @NotBlank @NotEmpty(message = "Nome não pode ser nulo") String nome,
        @Email @NotBlank @NotEmpty(message = "Email não pode ser nulo") String email,
        @NotBlank @NotEmpty(message = "Senha não pode ser nula") String senha
) {}
