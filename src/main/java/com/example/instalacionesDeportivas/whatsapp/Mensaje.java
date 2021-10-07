package com.example.instalacionesDeportivas.whatsapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Mensaje {
    
    private void EnviarMensaje(){
        
        String ID="ZIExz5EC6k0Le8IQ9ZBDzGFyaWVsMTk5MzJfYXRfZ21haWxfZG90X2NvbQ==";
        String telefono="65476532";
        String message="hola";
        
        
        HttpURLConnection conexion = null;
        
        try {
            
            URL enlace = new URL("https://NiceApi.net/API");
            
            conexion = (HttpURLConnection) enlace.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("X-APIId", ID);
            conexion.setRequestProperty("X-APIMobile", telefono);
            conexion.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conexion.setDoOutput(true);
            
            DataOutputStream salida = new DataOutputStream(conexion.getOutputStream());
            salida.writeBytes(message);
            salida.close();
            
            InputStream entrada = conexion.getInputStream();
            BufferedReader lectura = new BufferedReader(new InputStreamReader(entrada));
            
            System.out.println("Le hemos enviado la reserva a su teléfono");
            lectura.close();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(conexion != null){
                conexion.disconnect();
            }
        }
    }
}
