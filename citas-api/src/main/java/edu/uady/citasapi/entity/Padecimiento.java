package edu.uady.citasapi.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "padecimiento")
@Data
@NoArgsConstructor

public class Padecimiento {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "id_cita")
    private int id_cita;

    @Column(name = "descripcion", length = 255)
    private String descripcion;
    
    @Column(name = "evolucion", length = 255)
    private String evolucion;
    
    @Column(name = "estado_actual", length = 255)
    private String estado_actual;
    
    @OneToOne
    @JoinColumn( name = "id_cita")
    private Cita cita;
}
    
    
