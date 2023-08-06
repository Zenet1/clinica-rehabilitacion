package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AntecedenteNoPatologicoDTO {

    private String habitos;
    private String baño;
    private String habitacion;
    private String tabaquismo;
    private String alcoholismo;
    private String vacunas;
    private String actividad_fisica;
    private String alimentacion;
    private String estado_civil;
    private String Zoonosis;
}
