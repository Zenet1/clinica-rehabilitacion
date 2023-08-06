package edu.uady.citasapi.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "diagnostico")
@Data
@NoArgsConstructor

public class Diagnostico {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "id_cita")
    private int id_cita;
    
    @Column(name = "id_sistema")
    private int id_sistema;

    @Column(name = "diagnostico", length = 255)
    private String diagnostico;
    
}
