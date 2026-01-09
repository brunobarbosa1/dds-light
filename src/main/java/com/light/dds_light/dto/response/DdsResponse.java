package com.light.dds_light.dto.response;

import com.light.dds_light.entity.StatusDds;
import java.time.LocalDateTime;

public record DdsResponse(
        Long id,
        String tema,
        String descricao,
        String palestrante,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        StatusDds status
) {
}