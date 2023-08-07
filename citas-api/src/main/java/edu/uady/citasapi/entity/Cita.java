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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaHora;

    @Column(name = "id_paciente")
    private int idPaciente;

    @Column(name = "id_paciente_type")
    private int idPacienteType;
    
    @Column(name = "id_status")
    private int idStatus;
    
    @Column(name = "numero_sesion")
    private int numeroSesion;
    
    @Column(name = "costo_terapia", precision = 2)
    private double costoTerapia;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private Diagnostico diagnostico;
    
    @ManyToOne
    @JoinColumn( name = "id_status",insertable=false, updatable=false)
    private CitaStatus status;
    
    @ManyToOne
    @JoinColumn( name = "id_paciente_type",insertable=false, updatable=false)
    private PacienteType paciente_type;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private Padecimiento padecimiento;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private ExploracionFisica exploracion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cita")
    @JsonIgnore
    private List<Estudios>  estudios;
}
