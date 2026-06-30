package com.csrodrigues.gymcontrol.domain.service;

import com.csrodrigues.gymcontrol.api.dto.request.UserRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.UserResponseDTO;
import com.csrodrigues.gymcontrol.api.mapper.UserMapper;
import com.csrodrigues.gymcontrol.domain.entity.User;
import com.csrodrigues.gymcontrol.domain.exception.BusinessException;
import com.csrodrigues.gymcontrol.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
}
