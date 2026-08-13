package com.csrodrigues.gymcontrol.api.dto.request;

import com.csrodrigues.gymcontrol.api.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;

public record ChangePasswordRequestDTO(
       @NotBlank  @ValidPassword String currentPassword,
      @NotBlank @ValidPassword String newPassword
) {}
