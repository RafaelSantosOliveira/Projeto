package com.example.LoginProjetor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;


@Entity(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NonNull
	@Size(max=120)
	private String nome;
	
	@NonNull
	@Size(max=80)
	private String login;
	
	@NonNull
	@Size(max=80)
	private String senha;
	
	@ManyToMany
	@JoinTable(
		name="usuario_permissao",
		joinColumns=@JoinColumn(name="usuario_id"),
		inverseJoinColumns=@JoinColumn(name="permissao_id")
	)
	
	private List<Permissao> permissoes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	public List<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", permissoes="
				+ permissoes + "]";
	}

	
	
	
	
}
