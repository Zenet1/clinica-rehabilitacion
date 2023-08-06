package edu.uady.citasapi.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "estudios")
@Data
@NoArgsConstructor

public class Estudios {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "id_cita")
    private int id_cita;
    
    @Column(name = "ubicacion", length = 255)
    private String ubicacion;
    
}