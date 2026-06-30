package com.csrodrigues.gymcontrol.domain.service;

import com.csrodrigues.gymcontrol.api.dto.request.LoginRequestDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;

    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Authentication login(LoginRequestDTO dto){
       Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                     dto.email(),
                     dto.password()
                ));
       return authentication;
    }
}
