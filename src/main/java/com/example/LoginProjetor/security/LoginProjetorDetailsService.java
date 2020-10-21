package com.example.LoginProjetor.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.LoginProjetor.model.Permissao;
import com.example.LoginProjetor.model.Usuario;
import com.example.LoginProjetor.repository.PermissaoRepository;
import com.example.LoginProjetor.repository.UsuarioRepository;



public class LoginProjetorDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PermissaoRepository permissaoRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String login)
		throws UsernameNotFoundException{
		
		
		Usuario usuario = usuarioRepository.findByLogin(login);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return new UsuarioSistema(usuario.getNome(), usuario.getLogin(), usuario.getSenha(), 
				authorities(usuario));
		
	}
	
	public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
		
		Collection<GrantedAuthority> autorizacoes = new ArrayList<>();
		
		List<Permissao> permissoes = permissaoRepository.findByUsuariosIn(usuario);
		
		for(Permissao permissao : permissoes) {
			autorizacoes.add(new SimpleGrantedAuthority("ROLE_" + permissao.getNome()));
		}
		
		return autorizacoes;
				
	}
}