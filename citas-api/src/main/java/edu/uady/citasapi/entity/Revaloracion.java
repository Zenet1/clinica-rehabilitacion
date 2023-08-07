package edu.uady.citasapi.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "revaloracion")
@Data
@NoArgsConstructor

public class Revaloracion {
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "id_diagnostico")
    private int id_diagnostico;
    
    @Column(name = "id_sistema")
    private int id_sistema;

    @Column(name = "diagnostico", length = 255)
    private String diagnostico;
    
    @ManyToOne
    @JoinColumn( name = "id_diagnostico")
    private Diagnostico diagnostico_padre;
    
    @OneToOne
    @JoinColumn( name = "id_sistema")
    private CatalogoSistemas sistema;
   
    
}
