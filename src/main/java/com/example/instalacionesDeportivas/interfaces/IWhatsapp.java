package com.example.instalacionesDeportivas.interfaces;

import com.example.instalacionesDeportivas.entities.reservas;

public interface IWhatsapp {
    public void enviarMensaje(String telefono, String mensaje);
    public void enviarReserva(String telefono, reservas reserva);
    public void editarReserva(String telefono, reservas reserva);
}
