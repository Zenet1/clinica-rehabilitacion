package edu.uady.pacientesapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor
public class Paciente {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Column(name = "apellidos", length = 60, nullable = false)
    private String apellidos;

    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", length = 255, nullable = false)
    private String direccion;

    @Column(name = "telefono", length = 60, nullable = false)
    private String telefono;

    @Column(name = "email", length = 60, nullable = false)
    private String email;

    @Column(name = "estado_civil", length = 40, nullable = false)
    private String estado_civil;

    @Column(name = "escolaridad", length = 40, nullable = false)
    private String escolaridad;

    @Column(name = "ocupacion", length = 60, nullable = false)
    private String ocupacion;

    @OneToMany(mappedBy = "paciente")
    private List<AntecedentesFamiliares> antecedentesFamiliares;

    @OneToMany(mappedBy = "paciente")
    private List<AntecedentesGinecoObstetricos> antecedentesGinecoObstetricos;

    @OneToMany(mappedBy = "paciente")
    private List<AntecedentesNoPatologicos> antecedentesNoPatologicos;

    @OneToMany(mappedBy = "paciente")
    private List<AntecedentesPatologicos> antecedentesPatologicos;

    @OneToMany(mappedBy = "paciente")
    private List<AntecedentesPerinatales> antecedentesPerinatales;


}
