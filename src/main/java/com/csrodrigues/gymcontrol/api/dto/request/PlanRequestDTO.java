package com.csrodrigues.gymcontrol.api.dto.request;

import com.csrodrigues.gymcontrol.domain.enums.PlanDuration;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PlanRequestDTO(
        @NotBlank(message = "Plan name is required")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Price is required")
        @DecimalMin(value = "0.01", message = "Price must be greater than zero")
        BigDecimal price,

        @NotNull(message = "Duration is required")
        PlanDuration duration

) { }

