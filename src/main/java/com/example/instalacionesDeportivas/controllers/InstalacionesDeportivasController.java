package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.entities.instalaciones;
import com.example.instalacionesDeportivas.entities.reservas;
import com.example.instalacionesDeportivas.entities.usuarios;

import com.example.instalacionesDeportivas.repositories.InstalacionesRepository;
import com.example.instalacionesDeportivas.repositories.ReservasRepository;
import com.example.instalacionesDeportivas.repositories.UsuariosRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstalacionesDeportivasController {

    @Autowired
    private ReservasRepository repoReservas;
    
    @Autowired
    private InstalacionesRepository repoInstalaciones;
    
    @Autowired
    private UsuariosRepository repoUsuarios;

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

    @GetMapping("/reservas") 
    public String reservas(Model m) {
        m.addAttribute("Reservas", new reservas()); 
        m.addAttribute("eventos", repoReservas.findAll());
        m.addAttribute("Instalaciones", repoInstalaciones.findAll());
        m.addAttribute("Usuarios", repoUsuarios.findAll());
        return "reservas/vistaReservas.html";
    }
    @GetMapping("/editarReserva")
    public String editarReserva(Model m, int IdR) {

        Optional<reservas> Reservas = repoReservas.findById(IdR);
        if (Reservas.isPresent()) {
            m.addAttribute("Reservas", Reservas.get());
        } else {
            return "redirect:verReservas";
        }
        return "/reservas/formularioReservas";
    }

    @GetMapping("/compra")
    public String compra() {
        return "compra/formularioCompra.html";
    }

}
