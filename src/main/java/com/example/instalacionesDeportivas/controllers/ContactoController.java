package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.services.ContactoService;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RolesAllowed({"ROLE_USER"})
public class ContactoController {
    
    @Autowired
    private ContactoService contactoService;
    
    @Value("${cuentaDestino}")
    public String emailCentro;
    
    @GetMapping("/verContacto")
    public String verContacto(){
        return "formularioContacto.html";
    }
    
    @PostMapping("/enviarMail")
    public String enviarMail(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("message") String message){
        
        String mensaje = message + "\n\n Datos de contacto: " + "\n Nombre: " + name + "\n Email: " + email;
        
        contactoService.enviarEmail(emailCentro, emailCentro, subject + " Contacto: " + email, mensaje);
        //contactoService.enviarEmail(from: email, to: "hiberussports@gmail.com", subject, message);
        
        return "formularioContacto";
    }     
}
