package com.example.instalacionesDeportivas.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto implements UserDetails {
	 private Integer id_usuario;
	 private String nombre;
	 private String pass;
	 private String tipo;
	 private String Imagen;
	 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(tipo.equals("Administrador")) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
		}else if(tipo.equals("Usuario")) {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
			
		}
		return null;
	}

	@Override
	public String getPassword() {
		
		return pass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
