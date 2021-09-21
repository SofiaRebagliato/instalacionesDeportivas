package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.services.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ContactoController {
    
    @Autowired
    private ContactoService contactoService;
    
    @Value("${cuentaDestino}")
    public String emailCentro;
    
    @GetMapping("/verContacto")
    public String verContacto(){
        return "contacto/formularioContacto.html";
    }
    
    @PostMapping("/enviarMail")
    public String enviarMail(Model m, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("subject") String subject, @RequestParam("message") String message){
        try{
            String mensaje = message + "\n\n Datos de contacto: " + "\n Nombre: " + name + "\n Email: " + email;
        
            contactoService.enviarEmail(emailCentro, emailCentro, subject + " Contacto: " + email, mensaje);
            //contactoService.enviarEmail(from: email, to: "hiberussports@gmail.com", subject, message);
            m.addAttribute("mensaje", "Mensaje enviado correctamente!");
            //JOptionPane.showContactoController(null, "Mensaje enviado correctamente!");
            /*redirectAttrs
                .addFlashAttribute("mensaje", "Mensaje enviado correctamente!")
                .addFlashAttribute("clase", "success");*/
        } catch (Exception ex) {
            ex.printStackTrace();
            m.addAttribute("error", "¡ERROR! El mensaje no se ha enviado");
            //JOptionPane.showMessageDialog(null, "¡ERROR! El mensaje no se ha enviado");
        }
        return "contacto/formularioContacto";
    }     
}
