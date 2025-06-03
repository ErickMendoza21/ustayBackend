package com.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.springboot.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  @Query("""
          SELECT t FROM Token t
          WHERE t.usuario.usuario_id = :id AND (t.isExpired = false OR t.isRevoked = false)
      """)
  List<Token> findAllValidTokenByUser(Integer id);

  Optional<Token> findByToken(String token);
}
