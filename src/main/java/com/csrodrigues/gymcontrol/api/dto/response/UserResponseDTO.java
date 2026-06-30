package com.csrodrigues.gymcontrol.api.dto.response;

import com.csrodrigues.gymcontrol.domain.enums.UserRole;

import java.time.LocalDateTime;

public record UserResponseDTO(
        String id,
        String email,
        UserRole userRole,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
