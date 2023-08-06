package edu.uady.citasapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor
public class Paciente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "nombre", length = 40)
    private String nombre;

    @Column(name = "apellidos", length = 60)
    private String apellidos;

    private Date fechaNacimiento;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Column(name = "telefono", length = 60)
    private String telefono;

    @Column(name = "email", length = 60)
    private String email;

    @Column(name = "estado_civil", length = 40)
    private String estado_civil;

    @Column(name = "escolaridad", length = 40)
    private String escolaridad;

    @Column(name = "ocupacion", length = 60)
    private String ocupacion;

}
