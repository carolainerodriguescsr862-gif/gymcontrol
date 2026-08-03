package com.csrodrigues.gymcontrol.domain.service;

import com.csrodrigues.gymcontrol.api.dto.request.LoginRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.UserLoginResponse;
import com.csrodrigues.gymcontrol.api.dto.response.UserResponseDTO;
import com.csrodrigues.gymcontrol.domain.entity.User;
import com.csrodrigues.gymcontrol.domain.enums.UserRole;
import com.csrodrigues.gymcontrol.domain.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService ;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public UserLoginResponse login(LoginRequestDTO dto){
       Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                     dto.email(),
                     dto.password()
                ));

       String token = jwtService.generateToken(authentication);

       return new UserLoginResponse(token, "Bearer");
    }

}
