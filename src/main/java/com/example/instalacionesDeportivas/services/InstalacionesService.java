package com.example.instalacionesDeportivas.services;

import com.example.instalacionesDeportivas.entities.instalaciones;
import com.example.instalacionesDeportivas.interfaces.IInstalaciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class InstalacionesService implements IInstalaciones{
    
//    private List<instalaciones> listaInstalaciones = new ArrayList<>();
//    
//    public InstalacionesService() {
//        //listaInstalaciones.add(new instalaciones(0, "Cancha de Baloncesto", "Fabulosa pista de baloncesto cubierta para poder disfrutar del deporte que más te gusta en cualquier estación del año", 'C:/Users/Sofia/Desktop/CursoJavaHiberus/instalacionesDeportivas/src/main/resources/static/images',  3.00));
//        //listaInstalaciones.add(new Alumno(0, "Voleibol", "Contamos con dos pistas de voleibal. Una cubierta y otra cerrada.", 3.00));
//        //listaInstalaciones.add(new Alumno(0, "Pista de tenis", "Magníficas pistas de tenis con variedad de superficies y características: tierra batida y resina, cubiertas y descubiertas; para alquilar independientemente de las condiciones climatológicas existentes.", 'C:/Users/Sofia/Desktop/CursoJavaHiberus/instalacionesDeportivas/src/main/resources/static/images',  3.00));
//        //listaInstalaciones.add(new Alumno(0, "Gimnasio", "La zona de gimnasio cuanta con una gran variedad de máquinas. Además contamos con un entrenador prsonal que te va a ayudar a conseguir tus objetivos", 3.00));
//    }
//
//    @Override
//    public void guardarInstalacion(instalaciones instalaciones) {
//        
//       Optional<instalaciones> guardarInstalacion = listaInstalaciones.stream()
//               .filter(instal -> instal.getIdInstalaciones() == instalaciones.getIdInstalaciones())
//               .findFirst();
//       
//        if (guardarInstalacion.isPresent()) {
//            guardarInstalacion.get().setIdInstalaciones(instalaciones.getIdInstalaciones());
//            guardarInstalacion.get().setNombre(instalaciones.getNombre());
//            guardarInstalacion.get().setImagen(instalaciones.getImagen());
//            guardarInstalacion.get().setDescripcion(instalaciones.getDescripcion());
//            guardarInstalacion.get().setPrecio(instalaciones.getPrecio());
//        } else {
//            instalaciones.setIdInstalaciones((int)(Math.random()*999999999));
//            listaInstalaciones.add(instalaciones);
//        }
//    }
//    
//    @Override
//    public void borrarInstalacion(int IdInstalaciones) {
//        listaInstalaciones.removeIf(instalaciones -> instalaciones.getIdInstalaciones() == IdInstalaciones);
//    }
//    
//    @Override
//    public List<instalaciones> getInstalaciones() {
//        return listaInstalaciones;
//    }
}
