package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.security.JwtFilter;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configura la seguridad HTTP
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Deshabilitar CSRF (por ser API REST)
            .csrf(csrf -> csrf.disable())

            // No usar sesiones (JWT es stateless)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            // Configura permisos para endpoints
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()  // Registro y login público
                // .requestMatchers("/api/cuarto/listarByDisponibilidad").permitAll()  // Registro y login público
                .anyRequest().authenticated()                 // Otros endpoints requieren autenticación
            )

            // Agregar el filtro JWT antes del filtro de autenticación estándar
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

            // DESHABILITAR HTTP BASIC EXPLÍCITAMENTE
            .httpBasic(httpBasic -> httpBasic.disable()); // <--- ¡CAMBIO AQUÍ!
            // O simplemente .httpBasic(Customizer.disabled()); si estás en una versión más reciente
            // O directamente no llamar a .httpBasic() si no lo necesitas en absoluto.
            // .and(); // Si es necesario encadenar
        ;

        return http.build();
    }
}