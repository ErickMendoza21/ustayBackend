package com.springboot.service.security;

import com.springboot.dto.RegisterRequest;
import com.springboot.entity.Rol;
import com.springboot.entity.Usuario;
import com.springboot.repository.RolRepository;
import com.springboot.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RegisterService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;

    public RegisterService(UsuarioRepository usuarioRepository, RolRepository rolRepository,
                           PasswordEncoder passwordEncoder, EmailService emailService) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }

    private final long VERIFICATION_CODE_EXPIRATION_MINUTES = 15;

    @Transactional
    public String register(RegisterRequest request) {
        // 1. Verificar si el username (que ahora es el email) ya existe
        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("El correo electrónico '" + request.getUsername() + "' ya está registrado.");
        }

        // 2. Buscar el rol por defecto
        Rol rolUsuario = rolRepository.findByRol("USER")
                .orElseThrow(() -> new RuntimeException("Rol 'USER' no encontrado en la base de datos. Por favor, asegúrate de que exista."));

        // 3. Generar el código de verificación y calcular su fecha de expiración
        String verificationCode = CodeGenerator.generateCode();
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(VERIFICATION_CODE_EXPIRATION_MINUTES);

        // 4. Crear una nueva instancia de Usuario y setear sus propiedades
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellidoPa(request.getApellidoPa());
        usuario.setApellidoMa(request.getApellidoMa());
        usuario.setUsername(request.getUsername()); // El username AHORA ES EL EMAIL
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol(rolUsuario);
        usuario.setVerificationCode(verificationCode);
        usuario.setVerificationCodeExpiryDate(expiryDate);
        usuario.setEnabled(false);

        // 5. Guardar el nuevo usuario
        usuarioRepository.save(usuario);

        // 6. Enviar el correo electrónico con el código de verificación
        // toEmail ahora es usuario.getUsername()
        emailService.sendVerificationEmail(usuario.getUsername(), usuario.getNombre(), verificationCode);

        return "Registro exitoso. Se ha enviado un código de verificación a tu correo electrónico (" + request.getUsername() + "). Por favor, revísalo para activar tu cuenta.";
    }

    @Transactional
    public String verifyAccount(String email, String code) { // 'email' aquí es el username del usuario
        // 1. Buscar al usuario por su username (que es el email)
        Optional<Usuario> optionalUsuario = usuarioRepository.findByUsername(email); // Usamos findByUsername

        if (optionalUsuario.isEmpty()) {
            // El mensaje 'Usuario no encontrado con el email' sigue siendo apropiado
            throw new UsernameNotFoundException("Usuario no encontrado con el email: " + email);
        }

        Usuario usuario = optionalUsuario.get();

        if (usuario.isEnabled()) {
            return "Tu cuenta ya ha sido verificada previamente.";
        }

        // 3. Verificar si el código de verificación coincide
        if (!code.equals(usuario.getVerificationCode())) {
            throw new RuntimeException("El código de verificación proporcionado es incorrecto.");
        }

        // 4. Verificar si el código de verificación ha expirado
        if (usuario.getVerificationCodeExpiryDate() == null ||
            usuario.getVerificationCodeExpiryDate().isBefore(LocalDateTime.now())) {
            usuario.setVerificationCode(null);
            usuario.setVerificationCodeExpiryDate(null);
            usuarioRepository.save(usuario);
            throw new RuntimeException("El código de verificación ha expirado. Por favor, inicia un nuevo registro o solicita un reenvío del código.");
        }

        // 5. Habilitar la cuenta
        usuario.setEnabled(true);
        usuario.setVerificationCode(null);
        usuario.setVerificationCodeExpiryDate(null);
        usuarioRepository.save(usuario);

        return "¡Felicidades! Tu cuenta ha sido verificada exitosamente. Ya puedes iniciar sesión.";
    }
}