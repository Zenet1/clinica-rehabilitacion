package edu.uady.pacientesapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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

    @Column(name = "FUP", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate FUP;

    @Column(name = "abortos", length = 30)
    private int abortos;

    @Column(name= "cesareas", length = 30)
    private int cesareas;
}
