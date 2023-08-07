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
@Table(name = "paciente_type")
@Data
@NoArgsConstructor
public class PacienteType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "nombre", length = 255)
    private String nombre;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente_type")
    @JsonIgnore
    private List<Cita>  citas;


}

