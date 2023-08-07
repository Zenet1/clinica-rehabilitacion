package edu.uady.citasapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CitaDTO {

    private int id_paciente;
    private LocalDate fecha_hora;
    private int id_paciente_type;
    private int id_status;
    private int numero_sesion;
    private double costo_terapia;
}
