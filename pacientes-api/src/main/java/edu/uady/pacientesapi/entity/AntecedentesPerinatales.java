package edu.uady.pacientesapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "antecedentes_perinatales")
@Data
@NoArgsConstructor
public class AntecedentesPerinatales {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "nacimiento")
    private Date nacimiento;

    @Column(name = "SDG", length = 30)
    private int SDG;

    @Column(name = "APGAR")
    private String APGAR;

    @Column(name = "talla", length = 30)
    private int talla;

    @Column(name = "embarazos", length = 30)
    private int embarazos;

    @Column (name ="PDP")
    private String PDP;


}
