package com.csrodrigues.gymcontrol.config;

import com.csrodrigues.gymcontrol.domain.entity.User;
import com.csrodrigues.gymcontrol.domain.enums.UserRole;
import com.csrodrigues.gymcontrol.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAdmConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public DatabaseAdmConfig(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        boolean adminExists = userRepository.existsByUserRole(UserRole.ADMIN);

        if (!adminExists) {
            User admin = new User();
            admin.setEmail("admin@gymcontrol.com");

            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setUserRole(UserRole.ADMIN);

            userRepository.save(admin);
        }
    }
}
