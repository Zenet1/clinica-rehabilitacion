package edu.uady.pacientesapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "antecedentes_patologicos")
@Data
@NoArgsConstructor
public class AntecedentesPatologicos {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "cirugias")
    private String cirugias;

    @Column(name = "adicciiones")
    private String adicciones;

    @Column(name = "traumatismos")
    private String traumatismos;

    @Column(name = "ETS")
    private String ETS;

    @Column(name = "alergias")
    private String alergias;

    @Column(name = "padecimientos_articulares")
    private String padecimientos_articulares;



}
