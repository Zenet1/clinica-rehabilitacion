package edu.uady.citasapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class RevaloracionDTO {
    private int idDiagnostico;
    private int idSistema;
    private Date fecha;
    private String diagnostico;
}
