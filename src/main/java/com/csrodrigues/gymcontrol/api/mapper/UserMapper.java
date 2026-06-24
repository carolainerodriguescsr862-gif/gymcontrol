package com.csrodrigues.gymcontrol.api.mapper;

import com.csrodrigues.gymcontrol.api.dto.UserRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.UserResponseDTO;
import com.csrodrigues.gymcontrol.domain.entity.User;
import com.csrodrigues.gymcontrol.domain.enums.UserRole;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto, String encryptedPassword){
        return new User(
                dto.getEmail(),
                encryptedPassword,
                UserRole.MEMBER
        );
    }

    public static UserResponseDTO toDTO(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getUserRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
