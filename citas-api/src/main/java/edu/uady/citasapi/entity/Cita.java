package edu.uady.citasapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "citas")
@Data
@NoArgsConstructor
public class Cita {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora")
    private LocalDateTime fecha_hora;

    @Column(name = "id_paciente")
    private int id_paciente;

    @Column(name = "id_paciente_type")
    private int id_paciente_type;
    
    @Column(name = "id_status")
    private int id_status;
    
    @Column(name = "numero_sesion")
    private int numero_sesion;
    
    @Column(name = "costo_terapia", precision = 2)
    private double costo_terapia;
    
}
