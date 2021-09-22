package com.example.instalacionesDeportivas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.instalacionesDeportivas.entities.usuarios;
import com.example.instalacionesDeportivas.repositories.UsuariosRepository;

import dto.UsuarioDto;
@Service
public class ValidacionService implements UserDetailsService{
 
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<usuarios> usuarios =repoUsuarios.findByNombre(username);
		if(usuarios.isPresent()) {
			UsuarioDto user = new UsuarioDto(
						usuarios.get().getId_usuario(),
						usuarios.get().getNombre(),
						usuarios.get().getPass(),
						usuarios.get().getTipo());
			return user;	
		}throw new UsernameNotFoundException("Usuario o contraseña incorrecto");
		
		
	}

}
