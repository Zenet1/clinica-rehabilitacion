package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PacienteDTO {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String estado_civil;
    private String escolaridad;
    private String ocupacion;

}
