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
    public int IdUsuario;
    private String Apellido1;
    private String Apellido2;
    private String Dni;
    private String Email;
    private String Estado;
    private String Imagen;
    private String Nombre;
    private String Pass;
    private String Tipo;
   
    
    @OneToMany(mappedBy = "usuarios") 
    private List<reservas> reservas;
    
}