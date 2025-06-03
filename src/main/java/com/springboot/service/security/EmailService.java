package com.springboot.service.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}") // Lee el email del remitente desde application.properties
    private String senderEmail;

    // Inyección de dependencia a través del constructor (preferida en Spring Boot)
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Envía un correo electrónico de verificación de cuenta al usuario.
     *
     * @param toEmail  La dirección de correo electrónico del destinatario.
     * @param username El nombre del usuario (para personalizar el saludo).
     * @param code     El código de verificación a enviar.
     */
    public void sendVerificationEmail(String toEmail, String username, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail); // Establece el remitente del correo
        message.setTo(toEmail);       // Establece el destinatario
        message.setSubject("Verificación de cuenta en Ustay"); // Asunto del correo

        // Contenido del cuerpo del correo electrónico
        String emailContent = "Hola " + username + ",\n\n"
                            + "Gracias por registrarte en Ustay. Por favor, utiliza el siguiente código para verificar tu cuenta:\n\n"
                            + "Código de verificación: " + code + "\n\n"
                            + "Este código expirará en 15 minutos. Si no te registraste en Ustay, ignora este correo.\n\n"
                            + "Saludos,\n"
                            + "El equipo de Ustay";

        message.setText(emailContent); // Establece el contenido del correo

        try {
            mailSender.send(message); // Envía el correo
            logger.info("Correo de verificación enviado a {} con código {}", toEmail, code);
        } catch (MailException e) {
            logger.error("Error al enviar correo de verificación a {}: {}", toEmail, e.getMessage());
            // Es crucial manejar la excepción aquí. Puedes relanzarla como una RuntimeException
            // para que Spring la propague y sea capturada por un @ControllerAdvice,
            // o manejarla de otra forma (ej. registrar en DB un intento fallido).
            throw new RuntimeException("Error al enviar correo de verificación. Por favor, intente de nuevo más tarde.");
        }
    }
}