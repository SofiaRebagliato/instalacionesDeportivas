package com.example.instalacionesDeportivas.entities;

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
@Table(name = "reservas_horarios")
public class reservasHorarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdReservasHorarios;
    
    @ManyToOne
    @JoinColumn(name = "IdHorario")
    private horariosInstalaciones horariosInstalaciones;
    
    @ManyToOne
    @JoinColumn(name = "IdR")
    private reservas reservas;
}
