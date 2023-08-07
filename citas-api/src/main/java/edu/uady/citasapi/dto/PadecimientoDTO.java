package edu.uady.citasapi.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PadecimientoDTO {
 
    private Date fecha;
    private String descripcion;
    private String evolucion;
    private String estado_actual;
    private int id_cita;
}
