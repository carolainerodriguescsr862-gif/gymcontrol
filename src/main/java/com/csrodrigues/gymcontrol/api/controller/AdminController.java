package com.csrodrigues.gymcontrol.api.controller;

import com.csrodrigues.gymcontrol.api.dto.response.UserResponseDTO;
import com.csrodrigues.gymcontrol.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PatchMapping("/users/{id}/promote")
    public ResponseEntity<Void> promoteToInstructor(@PathVariable String id) {
        userService.promoteToInstructor(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {

        List<UserResponseDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

}
