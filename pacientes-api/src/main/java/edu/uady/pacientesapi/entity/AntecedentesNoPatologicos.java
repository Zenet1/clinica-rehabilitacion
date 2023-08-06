package edu.uady.pacientesapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "antecedentes_no_patologicos")
@Data
@NoArgsConstructor
public class AntecedentesNoPatologicos {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "habitos")
    private String habitos;

    @Column(name = "baño")
    private String baño;

    @Column(name = "habitacion")
    private String habitacion;

    @Column(name = "tabaquismo")
    private String tabaquismo;

    @Column(name = "alcoholismo")
    private String alcoholismo;

    @Column(name = "vacunas")
    private String vacunas;

    @Column(name = "actividad_fisica")
    private String actividad_fisica;

    @Column(name = "alimentacion")
    private String alimentacion;

    @Column(name = "estado_civil")
    private String estado_civil;

    @Column(name = "Zoonosis")
    private String Zoonosis;
}
