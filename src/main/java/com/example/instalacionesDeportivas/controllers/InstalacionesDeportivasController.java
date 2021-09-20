package com.example.instalacionesDeportivas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstalacionesDeportivasController {
    
	@GetMapping("/index")
	public String getIndex() {
            return "inicio/index.html";
	}
        
	@GetMapping("/login")
	public String login() {
            return "Login/vistaLogin.html";
	}
        
        @GetMapping("/contacto")
	public String contacto() {
            return "contacto/formularioContacto.html";
	}
        
}
