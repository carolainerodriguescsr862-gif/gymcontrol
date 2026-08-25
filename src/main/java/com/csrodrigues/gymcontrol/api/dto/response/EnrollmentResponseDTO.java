package com.csrodrigues.gymcontrol.api.dto.response;

import com.csrodrigues.gymcontrol.domain.enums.EnrollmentStatus;

import java.time.LocalDateTime;

public record EnrollmentResponseDTO(
        String id,
        MemberResponseDTO member,
        PlanResponseDTO plan,
        EnrollmentStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
