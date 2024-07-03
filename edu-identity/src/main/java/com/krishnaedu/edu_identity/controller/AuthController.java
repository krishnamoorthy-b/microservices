package com.krishnaedu.edu_identity.controller;

import com.krishnaedu.edu_identity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/token")
    public ResponseEntity<?> generateToken(){
        return ResponseEntity.ok(authService.generateToken());
    }

    @PostMapping(value = "/token/verify1")
    public ResponseEntity<?> test(){
        return ResponseEntity.ok("test...");
    }

    @PostMapping(value = "/token/verify")
    public ResponseEntity<?> verifyToken(@RequestBody String token){
        return ResponseEntity.ok(authService.verifyToken(token));
    }

}
