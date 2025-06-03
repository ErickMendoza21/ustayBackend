package com.springboot.controller.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.dto.JwtResponse;
import com.springboot.dto.LoginRequest;
import com.springboot.dto.RegisterRequest;
import com.springboot.service.security.LoginService;
import com.springboot.service.security.RegisterService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final RegisterService registerService;
    private final LoginService loginService;

    // Se recomienda la inyección de dependencias por constructor
    public AuthController(RegisterService registerService, LoginService loginService) {
        this.registerService = registerService;
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        // Llama al servicio de registro, que ahora devuelve el mensaje directamente
        String message = registerService.register(request);
        return ResponseEntity.ok(message); // Devuelve el mensaje en el cuerpo de la respuesta HTTP 200 OK
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyAccount(@RequestParam String email, @RequestParam String code) {
        // Nuevo endpoint para la verificación de cuenta
        String message = registerService.verifyAccount(email, code);
        return ResponseEntity.ok(message); // Devuelve el mensaje de éxito o ya verificado
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest request) {
        JwtResponse jwtResponse = loginService.login(request);
        return ResponseEntity.ok(jwtResponse);
    }
}