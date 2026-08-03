package com.csrodrigues.gymcontrol.domain.service;

import com.csrodrigues.gymcontrol.api.dto.request.UserRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.UserResponseDTO;
import com.csrodrigues.gymcontrol.api.mapper.UserMapper;
import com.csrodrigues.gymcontrol.domain.entity.User;
import com.csrodrigues.gymcontrol.domain.enums.UserRole;
import com.csrodrigues.gymcontrol.domain.exception.BusinessException;
import com.csrodrigues.gymcontrol.domain.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseDTO register(UserRequestDTO dto){
        boolean exists = userRepository.existsByEmail(dto.getEmail());

        if(exists){
           throw  new BusinessException("There is already a user with that email!");
        }
        String encryptedPassword = passwordEncoder.encode(dto.getPassword());

        User user = UserMapper.toEntity(dto, encryptedPassword);
        User saved = userRepository.save(user);

    return UserMapper.toDTO(saved);

    }

    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public List<UserResponseDTO> findAll(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }


    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    public void promoteToInstructor(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));

        if (user.getUserRole() == UserRole.ADMIN) {
            throw new IllegalStateException("An Administrator cannot be demoted to an Instructor.");
        }

        if (user.getUserRole() == UserRole.INSTRUCTOR) {
            throw new IllegalStateException("This user is already an Instructor.");
        }

        user.setUserRole(UserRole.INSTRUCTOR);
        userRepository.save(user);

    }

}
