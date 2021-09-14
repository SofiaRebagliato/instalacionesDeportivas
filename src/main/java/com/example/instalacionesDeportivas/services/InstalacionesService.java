package com.example.instalacionesDeportivas.services;

import com.example.instalacionesDeportivas.entities.instalaciones;
import com.example.instalacionesDeportivas.interfaces.IInstalaciones;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InstalacionesService implements IInstalaciones{
    
    private List<instalaciones> listaInstalaciones = new ArrayList<>();
    
    public InstalacionesService() {
        //listaInstalaciones.add(new instalaciones(0, "pista de tenis", "", "", "", ));
        //listaAlumnos.add(new Alumno(2L, "Ana", "444", "C/rwr"));
        //listaAlumnos.add(new Alumno(3L, "Pedro", "6753648", "C/pogbtr"));
        //listaAlumnos.add(new Alumno(4L, "Lucas", "6543895", "C/hygdtfrb"));
    }
}
