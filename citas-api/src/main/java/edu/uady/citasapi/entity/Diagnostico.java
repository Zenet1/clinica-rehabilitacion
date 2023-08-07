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
    
    @OneToOne
    @JoinColumn( name = "id_cita")
    private Cita cita;
    
    @OneToOne
    @JoinColumn( name = "id_sistema")
    private CatalogoSistemas sistema;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "diagnostico_padre")
    @JsonIgnore
    private List<Revaloracion> revaloracion;
}
