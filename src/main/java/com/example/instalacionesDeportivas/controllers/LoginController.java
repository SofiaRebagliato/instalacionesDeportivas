package com.example.instalacionesDeportivas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.instalacionesDeportivas.dto.UsuarioDto;



@Controller

public class LoginController {

	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping("/loginUser")
	public String loginUser(String nombre, String pass) {
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(nombre, pass);
		Authentication auth=manager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "redirect:/index";
	}
	
	@GetMapping("/infoUser")
	@ResponseBody
	public UsuarioDto info() {
		UsuarioDto user=(UsuarioDto)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return user;
	}
	
}
