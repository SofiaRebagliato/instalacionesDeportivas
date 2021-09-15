package com.example.instalacionesDeportivas.interfaces;

import com.example.instalacionesDeportivas.entities.instalaciones;
import java.util.List;

public interface IInstalaciones {
    
    /**
     * Busca el ID de la instalación y si ya existe modifica el resto de campos (o lo sustituye)
     * si no está el ID la inserta.
     */
     public void guardarInstalacion(instalaciones instalaciones);
     
     /**
     * Borra la instalación del ID indicado.
     */
     public void borrarInstalacion(int IdInstalaciones);
     
     /**
     * Devuelve todas las instalaciones.
     */
     public List<instalaciones> getInstalaciones();
}
