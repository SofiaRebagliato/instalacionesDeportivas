/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instalacionesDeportivas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Sofia
 */
@Controller
public class InstalacionesDeportivasController {
    
	@GetMapping("/index")
	@ResponseBody
	public String getPrueba() {
		return "index.html";
	}
}
