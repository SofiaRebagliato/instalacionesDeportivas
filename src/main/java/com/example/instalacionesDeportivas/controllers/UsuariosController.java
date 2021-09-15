package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.entities.usuarios;
import com.example.instalacionesDeportivas.repositories.UsuariosRepository;
import com.example.instalacionesDeportivas.services.UsuariosService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controlador/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository repoUsuarios;
    
    @Autowired
    private UsuariosService UsuariosService;
    
    @GetMapping("/verUsuarios")
    public String verUsuarios(Model m) {
        m.addAttribute("Usuarios", repoUsuarios.findAll());
        return "usuarios";
    }
    
    @GetMapping("/altaUsuarios")
    public String altaUsuarios(Model m) {
        m.addAttribute("Usuarios", new usuarios());
        return "usuarios";
    }
    
    @GetMapping("/editarUsuarios")
    public String editarUsuarios(Model m, int IdUsuario) {

        Optional<usuarios> Usuarios = repoUsuarios.findById(IdUsuario);
        if (Usuarios.isPresent()) {
            m.addAttribute("Usuarios", Usuarios.get());
        } else {
            return "redirect:verUsuarios";
        }
        return "formularioUsuarios";
    }
    
    @PostMapping("/guardarUsuarios")
    public String guardarUsuarios(Model m, usuarios usuario) {
        repoUsuarios.save(usuario);
        return "redirect:verUsuarios";
    }
    
    @GetMapping("/borrarUsuarios")
    public String borrarInstalacion(Model m, int id) {
        repoUsuarios.deleteById(id);
        return "redirect:verUsuarios";
    }
}

