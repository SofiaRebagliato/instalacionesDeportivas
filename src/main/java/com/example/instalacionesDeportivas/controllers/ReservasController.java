package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.dto.UsuarioDto;
import com.example.instalacionesDeportivas.entities.instalaciones;
import com.example.instalacionesDeportivas.entities.reservas;
import com.example.instalacionesDeportivas.entities.usuarios;
import com.example.instalacionesDeportivas.repositories.InstalacionesRepository;
import com.example.instalacionesDeportivas.repositories.ReservasRepository;
import com.example.instalacionesDeportivas.repositories.UsuariosRepository;
import com.example.instalacionesDeportivas.services.ReservasService;
import java.util.List;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
@Controller
@RequestMapping("/reservas")
public class ReservasController {
    
    @Autowired
    private ReservasRepository repoReservas;
    
    @Autowired
    private InstalacionesRepository repoInstalaciones;
    
    @Autowired
    private UsuariosRepository repoUsuarios;
    
    @Autowired
    private ReservasService ReservasService;
        
    @GetMapping("/construccion")
    public String login() {
        return "Construc/ComingSoon.html";
    }
    @GetMapping("/verReservas")
    public String verReservas(Model m, HttpServletRequest r) {
        if ( r.isUserInRole("ROLE_ADMIN")) {
            m.addAttribute("Reservas", repoReservas.findAll());
        } else {
            m.addAttribute("Reservas", repoUsuarios.findById(usuarioDto().getId_usuario()).get().getReservas());
        }
        return "/reservas/vistaReservas";
    }
    
    @GetMapping("/nuevaReserva")
    public String nuevaReserva(Model m) {
        m.addAttribute("Reservas", new reservas());
        return "reservas/vistaReservas";
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
    
    @ModelAttribute("UserSession")
    public UsuarioDto usuarioDto(){
        return (UsuarioDto)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
    
    @ModelAttribute("Instalaciones")
    public List<instalaciones> verInstalaciones(){
        return repoInstalaciones.findAll();
    }
    
    @ModelAttribute("Usuarios")
    public List<usuarios> verUsuarios(){
        return repoUsuarios.findAll();
    }
    
    @PostMapping("/guardarReserva")
    public String guardarReserva(Model m, reservas reservas, Integer idInstalacion) {
        UsuarioDto user=(UsuarioDto)(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        reservas.setInstalaciones(repoInstalaciones.findById(idInstalacion).get());
        reservas.setUsuarios(repoUsuarios.findById(user.getId_usuario()).get());
        reservas.setPrecio(reservas.getInstalaciones().getPrecio());
        repoReservas.save(reservas);
        return "redirect:/reservas";
    }
    
    @GetMapping("/borrarReserva")
    public String borrarUsuarios(Model m, int IdR) {
        repoReservas.deleteById(IdR);
        return "redirect:/reservas";
    }
    
}
