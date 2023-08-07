package edu.uady.citasapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RevaloracionDTO {
    private int id_diagnostico;
    private int id_sistema;
    private LocalDate fecha;
    private String diagnostico;
}
