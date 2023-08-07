package edu.uady.pacientesapi.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class AntecedenteGinecoObstetricoDTO {

    private Date menarca;
    private String ritmo_menstrual;
    private int IPSA;
    private int partos;
    private LocalDate FUP;
    private int abortos;
    private int cesareas;
}
