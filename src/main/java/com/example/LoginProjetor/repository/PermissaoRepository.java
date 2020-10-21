package com.example.LoginProjetor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LoginProjetor.model.Permissao;
import com.example.LoginProjetor.model.Usuario;


public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

	public List<Permissao> findByUsuariosIn(Usuario ... usuario);
	
	
	
}
