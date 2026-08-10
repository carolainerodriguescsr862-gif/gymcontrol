package com.csrodrigues.gymcontrol.api.dto.response;

import com.csrodrigues.gymcontrol.domain.enums.PlanDuration;

import java.math.BigDecimal;

public record PlanResponseDTO(
        String id,
        String name,
        String description,
        BigDecimal price,
        PlanDuration duration,
        boolean active
) { }
