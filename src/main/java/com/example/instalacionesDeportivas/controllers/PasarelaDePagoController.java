package com.example.instalacionesDeportivas.controllers;

import com.example.instalacionesDeportivas.services.PasarelaDePagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/pago")
public class PasarelaDePagoController {
    
    @Autowired
    private PasarelaDePagoService pasarelaDePagoService;
        
    @GetMapping("/verPasarelaDePago")
    public String verPasarelaDePago(){
        return "compra/formularioCompra.html";
    }
       
}
