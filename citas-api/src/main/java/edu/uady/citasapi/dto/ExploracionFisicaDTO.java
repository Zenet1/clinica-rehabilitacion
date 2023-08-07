package edu.uady.citasapi.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExploracionFisicaDTO {
    private String exploracion;
    private Date fecha;
    private int id_cita;
}
