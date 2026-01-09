package com.light.dds_light.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public record DdsRequest(
        @NotEmpty(message = "Tema não pode ser nulo")
        @NotBlank
        String tema,
        @NotEmpty(message = "Descrição não pode ser nula")
        @NotBlank
        String descricao,
        @NotEmpty(message = "Nome do palestrante não pode ser nulo")
        @NotBlank
        String palestrante,
        @NotEmpty(message = "Data de início não pode ser nula")
        @NotBlank
        LocalDateTime dataInicio,
        @NotEmpty(message = "Data fim não pode ser nula")
        @NotBlank
        LocalDateTime dataFim
) {
}