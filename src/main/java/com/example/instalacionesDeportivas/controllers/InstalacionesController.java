package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.entities.instalaciones;
import com.example.instalacionesDeportivas.repositories.InstalacionesRepository;
import com.example.instalacionesDeportivas.services.InstalacionesService;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
@Controller
@RequestMapping("/instalaciones")
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
//    @Secured({"ROLE_ADMIN"})
    public String verInstalacion(Model m) {
        m.addAttribute("Instalaciones", repoInstalaciones.findAll());
        return "/instalaciones/vistaInstalaciones";
    }
    @GetMapping("/vistaInstalacion")
//  @Secured({"ROLE_ADMIN"})
  public String vistaInstalacion(Model m) {
      return "/instalaciones/instalaciones";
  }
    
    @GetMapping("/altaInstalacion")//crear
//    @Secured({"ROLE_ADMIN"})
    public String altaInstalacion(Model m) {
        m.addAttribute("Instalaciones", new instalaciones());
        return "instalaciones/formularioInstalaciones";
    }
    
    @GetMapping("/editarInstalacion")//actualizar
//    @Secured({"ROLE_ADMIN"})
    public String editarInstalacion(Model m, int IdInstalaciones) {

        Optional<instalaciones> Instalaciones = repoInstalaciones.findById(IdInstalaciones);
        if (Instalaciones.isPresent()) {
            m.addAttribute("Instalaciones", Instalaciones.get());
        } else {
            return "redirect:verInstalacion";
        }
        return "/instalaciones/formularioInstalaciones";
    }
    
    @PostMapping("/guardarInstalacion")//guardar
//    @Secured({"ROLE_ADMIN"})
    public String guardarInstalacion(Model m, instalaciones instalacion) {
        repoInstalaciones.save(instalacion);
        return "redirect:verInstalacion";
    }
    
    @GetMapping("/borrarInstalacion")//borrar
//    @Secured({"ROLE_ADMIN"})
    public String borrarInstalacion(Model m, int IdInstalaciones) {
        repoInstalaciones.deleteById(IdInstalaciones);
        return "redirect:verInstalacion";
    }
}
