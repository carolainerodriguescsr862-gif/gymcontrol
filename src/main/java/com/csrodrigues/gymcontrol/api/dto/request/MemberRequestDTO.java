package com.csrodrigues.gymcontrol.api.dto.request;


import jakarta.validation.constraints.NotBlank;

public record MemberRequestDTO(
        @NotBlank(message = "User ID is required")
        String userId
) { }
