package edu.uady.citasapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class CitaDTO {

    private int idPaciente;
    private LocalDateTime fechaHora;
    private int idPacienteType;
    private int idStatus;
    private int numeroSesion;
    private double costoTerapia;
}
