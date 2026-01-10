package com.light.dds_light.dto.request;

import java.time.LocalDateTime;

public record DdsUpdateRequest(
        String tema,
        String descricao,
        String palestrante,
        LocalDateTime dataInicio,
        LocalDateTime dataFim
) {
}
