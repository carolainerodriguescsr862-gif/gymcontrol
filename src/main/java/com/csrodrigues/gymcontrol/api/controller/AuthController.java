package com.csrodrigues.gymcontrol.api.controller;

import com.csrodrigues.gymcontrol.api.dto.request.LoginRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.request.UserRequestDTO;
import com.csrodrigues.gymcontrol.api.dto.response.UserLoginResponse;
import com.csrodrigues.gymcontrol.api.dto.response.UserResponseDTO;
import com.csrodrigues.gymcontrol.domain.service.AuthService;
import com.csrodrigues.gymcontrol.domain.service.JwtService;
import com.csrodrigues.gymcontrol.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody UserRequestDTO data){
        var newUser = userService.register(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody LoginRequestDTO data){
       var response = authService.login(data);
       return ResponseEntity.ok(response);

    }
}
