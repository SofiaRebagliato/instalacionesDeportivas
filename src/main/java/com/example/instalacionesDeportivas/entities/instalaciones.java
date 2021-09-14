package com.example.instalacionesDeportivas.entities;

import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instalaciones")
public class instalaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int IdInstalaciones;
    private String Nombre;
    private String Descripcion;
    private String Imagen;
    private Float Precio;
    
    @OneToMany(mappedBy = "instalaciones") 
    private List<reservas> reservas;
    
}