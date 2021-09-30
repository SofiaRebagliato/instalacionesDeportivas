package com.example.instalacionesDeportivas.entities;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservas")
public class reservas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IdR;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate Fecha;
    
    @DateTimeFormat(pattern = "HH-mm")
    private String Hora;
    
    private double Precio;
    
    @ManyToOne
    @JoinColumn(name = "IdUsuario")
    private usuarios usuarios;
    
    @ManyToOne
    @JoinColumn(name = "IdInstalacion")
    private instalaciones instalaciones;
}
