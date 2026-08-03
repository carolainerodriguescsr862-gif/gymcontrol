package com.csrodrigues.gymcontrol.domain.repository;

import com.csrodrigues.gymcontrol.domain.entity.User;
import com.csrodrigues.gymcontrol.domain.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    boolean existsByUserRole(UserRole userRole);

    Optional<User> findByEmail(String email);
}
