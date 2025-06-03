package com.springboot.service.security;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.dto.JwtResponse;
import com.springboot.dto.LoginRequest;
import com.springboot.entity.Usuario;
import com.springboot.repository.UsuarioRepository;
import com.springboot.security.JwtUtil;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public LoginService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

   public JwtResponse login(LoginRequest request) {
    Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(request.getUsername());

    if (usuarioOpt.isEmpty()) {
        throw new RuntimeException("Usuario no encontrado");
    }

    Usuario usuario = usuarioOpt.get();

    if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
        throw new RuntimeException("Contraseña incorrecta");
    }

    String token = jwtUtil.generateToken(usuario.getUsername(), usuario.getRol().getRol());
    String rol = usuario.getRol().getRol();

    return new JwtResponse(token, rol);
}

}
