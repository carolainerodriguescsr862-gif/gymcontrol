package com.csrodrigues.gymcontrol.domain.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String message,
        LocalDateTime timesTamp
) {
}
