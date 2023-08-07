package edu.uady.citasapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteAntecedentesFamiliaresDTO {
    private CitaDTO paciente;
    private List<DiagnosticoDTO> antecedentes_familiares;
}
