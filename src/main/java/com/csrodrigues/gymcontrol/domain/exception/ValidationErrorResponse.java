package com.csrodrigues.gymcontrol.domain.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ValidationErrorResponse(
        int status,
        String message,
        LocalDateTime timesTamp,
        List<FieldErrorDetails> errors
) {
}
