package com.csrodrigues.gymcontrol.api.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record EnrollmentRequestDTO(
       @NotBlank(message = "Member ID is required")
       String idMember,
       @NotBlank(message = "Plan ID is required")
       String idPlan,
       LocalDate startDate) {

}
