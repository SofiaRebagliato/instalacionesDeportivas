/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.instalacionesDeportivas.services;

import com.example.instalacionesDeportivas.entities.reservas;
import com.example.instalacionesDeportivas.interfaces.IWhatsapp;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message; 
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.NewKey;
import java.time.LocalDate;

@Service
public class WhatsappService implements IWhatsapp{

    //public static final String ACCOUNT_SID = "ACc2473a611aa4d99976d85ca38410de41"; 
    //public static final String AUTH_TOKEN = "[Redacted]"; 

    //POST https://api.twilio.com/2010-04-01/Accounts/{AccountSid}/Keys.json
    
    public static final String ACCOUNT_SID = ("ACc2473a611aa4d99976d85ca38410de41");
    public static final String AUTH_TOKEN = ("9ce2bb93928400cc42f74cb266cd7e60");
    
    @Override
    public void enviarMensaje(String telefono, String mensaje) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("whatsapp:+34" + telefono), 
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),  
                mensaje)      
            .create();         
        
    }

    @Override
    public void enviarReserva(String telefono, reservas reserva) {
        enviarMensaje(telefono, "Usted ha hecho la siguiente reserva: " + "\n" + 
                "Día: " + reserva.getFecha() + "\n" +
                "Hora: " + reserva.getHora() + " h" + "\n" +
                "Instalación: " + reserva.getInstalaciones().getNombre());
    }
    
    @Override
    public void editarReserva(String telefono, reservas reserva) {
        enviarMensaje(telefono, "Su reserva ha sido modificada: " + "\n" + 
                "Día: " + reserva.getFecha() + "\n" +
                "Hora: " + reserva.getHora() + " h" + "\n" +
                "Instalación: " + reserva.getInstalaciones().getNombre());
    }
  
    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        NewKey newKey = NewKey.creator().create();

        System.out.println(newKey.getSid());
    }
}
