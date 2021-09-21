package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.entities.reservas;
import com.example.instalacionesDeportivas.repositories.ReservasRepository;
import com.example.instalacionesDeportivas.services.ReservasService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservasController {
    
    @Autowired
    private ReservasRepository repoReservas;
    
    @Autowired
    private ReservasService ReservasService;
    
    @GetMapping("/verReservas")
    public String verReservas(Model m) {
        m.addAttribute("Reservas", repoReservas.findAll());
        return "/reservas/vistaReservas";
    }
    
    @GetMapping("/nuevaReserva")
    public String nuevaReserva(Model m) {
        m.addAttribute("Reservas", new reservas());
        return "reservas/formularioReservas";
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
    
    @PostMapping("/guardarReserva")
    public String guardarReserva(Model m, reservas reservas) {
        repoReservas.save(reservas);
        return "redirect:verReservas";
    }
    
    @GetMapping("/borrarReserva")
    public String borrarUsuarios(Model m, int IdR) {
        repoReservas.deleteById(IdR);
        return "redirect:verReservas";
    }
    
}
