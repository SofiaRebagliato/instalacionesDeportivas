package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.repositories.ReservasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstalacionesDeportivasController {

    @Autowired
    private ReservasRepository repoReservas;

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
        m.addAttribute("eventos", repoReservas.findAll());
        return "reservas/vistaReservas.html";
    }

    @GetMapping("/compra")
    public String compra() {
        return "compra/formularioCompra.html";
    }

}
