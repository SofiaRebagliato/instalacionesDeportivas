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
@Table(name = "horarios_instalaciones")
public class horariosInstalaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdHorario;
    
    @DateTimeFormat(pattern = "EEEE")
    private Date Dia_semana;
    
    @DateTimeFormat(pattern = "HH:mm")
    private Date Hora_inicio;
    private Date Hora_fin;
    
    @OneToMany(mappedBy = "horariosInstalaciones") 
    private List<reservasHorarios> reservasHorarios;
}