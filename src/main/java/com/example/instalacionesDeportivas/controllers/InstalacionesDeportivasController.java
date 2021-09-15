/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instalacionesDeportivas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.instalacionesDeportivas.repositories.InstalacionesRepository;

/**
 *
 * @author Sofia
 */
@Controller

public class InstalacionesDeportivasController {
	  @Autowired
	    private InstalacionesRepository repoInstalaciones;
    
	@GetMapping("/index")
	public String getPrueba(Model m) {
		m.addAttribute("instalaciones", repoInstalaciones.findAll());

		return "inicio/index.html";
	}
}
