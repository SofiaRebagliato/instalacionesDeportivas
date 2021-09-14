package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.entities.instalaciones;
import com.example.instalacionesDeportivas.repositories.InstalacionesRepository;
import com.example.instalacionesDeportivas.services.InstalacionesService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controlador/instalaciones")
public class InstalacionesController {
    
    @Autowired
    private InstalacionesRepository repoInstalaciones;
    
    @Autowired
    private InstalacionesService InstalacionesService;
    
    @GetMapping("/index")
    @ResponseBody
    public String getPrueba() {
            return "index.html";
    }
    
    @GetMapping("/verInstalacion")
    public String verInstalacion(Model m) {
        m.addAttribute("Instalaciones", repoInstalaciones.findAll());
        return "instalaciones";
    }
    
    @GetMapping("/altaInstalacion")
    public String altaInstalacion(Model m) {
        m.addAttribute("Instalaciones", new instalaciones());
        return "instalaciones";
    }
    
    @GetMapping("/editarInstalacion")
    public String editarInstalacion(Model m, int id) {

        Optional<instalaciones> Instalaciones = repoInstalaciones.findById(id);
        if (Instalaciones.isPresent()) {
            m.addAttribute("Instalaciones", Instalaciones.get());
        } else {
            return "redirect:verInstalacion";
        }
        return "formularioInstalacion";
    }
    
    @PostMapping("/guardarInstalacion")
    public String guardarInstalacion(Model m, instalaciones instalacion) {
        repoInstalaciones.save(instalacion);
        return "redirect:verInstalacion";
    }
    
    @GetMapping("/borrarInstalacion")
    public String borrarInstalacion(Model m, int id) {
        repoInstalaciones.deleteById(id);
        return "redirect:verInstalacion";
    }
}
