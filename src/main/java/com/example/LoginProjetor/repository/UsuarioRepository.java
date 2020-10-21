package com.example.LoginProjetor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LoginProjetor.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLogin(String login);

}
