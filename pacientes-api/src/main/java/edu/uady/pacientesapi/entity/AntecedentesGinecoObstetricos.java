package edu.uady.pacientesapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "antecedentes_gineco_obstetricos")
@Data
@NoArgsConstructor
public class AntecedentesGinecoObstetricos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @Column(name = "menarca")
    private Date menarca;

    @Column(name = "ritmo_menstrual")
    private String ritmo_menstrual;

    @Column(name = "IPSA", length = 30)
    private int IPSA;

    @Column(name = "partos", length = 30)
    private int partos;

    @Column(name = "FUP")
    private Date FUP;

    @Column(name = "abortos", length = 30)
    private int abortos;

    @Column(name= "cesareas", length = 30)
    private int cesareas;
}
