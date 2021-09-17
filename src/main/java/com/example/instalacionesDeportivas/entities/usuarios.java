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
@Table(name = "usuarios")
public class usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id_usuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String dni;
    private String pass;
    private String imagen;
    private String tipo;
    private String estado;
   
    
    @OneToMany(mappedBy = "usuarios") 
    private List<reservas> reservas;
    
}