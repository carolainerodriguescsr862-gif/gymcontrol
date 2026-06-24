package com.csrodrigues.gymcontrol.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN,
    MEMBER,
    INSTRUCTOR;

    @Override
    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
