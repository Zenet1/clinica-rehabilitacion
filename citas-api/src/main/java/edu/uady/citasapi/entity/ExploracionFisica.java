package edu.uady.citasapi.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "exploracion_fisica")
@Data
@NoArgsConstructor

public class ExploracionFisica {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_cita")
    private int idCita;
    
    @Column(name = "exploracion", length = 600)
    private String exploracion;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;
    
    @OneToOne
    @JoinColumn( name = "id_cita",insertable=false, updatable=false)
    private Cita cita;
}