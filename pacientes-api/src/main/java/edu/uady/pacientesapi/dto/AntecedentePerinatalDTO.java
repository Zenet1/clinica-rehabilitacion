package edu.uady.pacientesapi.dto;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AntecedentePerinatalDTO {
    private Date nacimiento;
    private int SDG;
    private String APGAR;
    private int talla;
    private int embarazos;
    private String PDP;
}
