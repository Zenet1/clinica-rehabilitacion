package edu.uady.pacientesapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Entity
@Table(name = "antecedentes_familiares")
@Data
@NoArgsConstructor
public class AntecedentesFamiliares {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @Column(name = "cardiopatias")
    private String cardiopatias;

    @Column(name = "alergias")
    private String alergias;

    @Column(name = "diabetes")
    private String diabetes;

    @Column(name = "nefropatias")
    private String nefropatias;

    @Column(name = "psiquiatricos")
    private String psiquiatricos;

    @Column(name = "neurologicas")
    private String neurologicas;


    @Column(name = "otros")
    private String otros;
}
