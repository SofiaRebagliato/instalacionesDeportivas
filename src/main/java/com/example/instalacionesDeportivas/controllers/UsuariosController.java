package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.entities.usuarios;
import com.example.instalacionesDeportivas.repositories.UsuariosRepository;
import com.example.instalacionesDeportivas.services.UsuariosService;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RolesAllowed({"ROLE_USER","ROLE_ADMIN"})
@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    
    @Autowired
    private UsuariosRepository repoUsuarios;
    
    @Autowired
    private UsuariosService UsuariosService;
    @Autowired
    private PasswordEncoder PassEncod;
    
    @GetMapping("/verUsuarios")
    @Secured({"ROLE_ADMIN"})
    public String verUsuarios(Model m) {
        m.addAttribute("Usuarios", repoUsuarios.findAll());
        return "/usuarios/vistaUsuarios";
    }
    
    @GetMapping("/altaUsuarios")
   @Secured({"ROLE_ADMIN"})
    public String altaUsuarios(Model m) {
        m.addAttribute("Usuarios", new usuarios());
        return "/usuarios/formularioUsuarios";
    }
    
    @GetMapping("/editarUsuarios")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public String editarUsuarios(Model m, int id_usuario) {

        Optional<usuarios> Usuarios = repoUsuarios.findById(id_usuario);
        if (Usuarios.isPresent()) {
            m.addAttribute("Usuarios", Usuarios.get());
        } else {
            return "redirect:verUsuarios";
        }
        return "/usuarios/formularioEditarUsuario";
    }
    
    @PostMapping("/guardarUsuarios")
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    public String guardarUsuarios(Model m, usuarios usuario) {
    	usuario.setPass(PassEncod.encode(usuario.getPass()));
        repoUsuarios.save(usuario);
        return "/inicio/index";
    }
    
    @GetMapping("/borrarUsuarios")
    @Secured({"ROLE_ADMIN"})
    public String borrarUsuarios(Model m, int id_usuario) {
        repoUsuarios.deleteById(id_usuario);
        return "redirect:verUsuarios";
    }
}

