package com.csrodrigues.gymcontrol.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN,
    STUDENT,
    INSTRUCTOR;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
