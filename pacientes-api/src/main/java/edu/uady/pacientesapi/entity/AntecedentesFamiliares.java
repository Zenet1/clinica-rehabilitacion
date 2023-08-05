package edu.uady.pacientesapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "antecedentes_familiares")
@Data
@NoArgsConstructor
public class AntecedentesFamiliares {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "cardiopatias", length = 255)
    private String cardiopatias;

    

}
