package com.csrodrigues.gymcontrol.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@PreAuthorize("hasAuthority('SCOPE_ROLE_MEMBER')")
public class TesteController {

    @GetMapping
    public ResponseEntity<String >test(){
        return ResponseEntity.ok("Hello world!");
    }
}
