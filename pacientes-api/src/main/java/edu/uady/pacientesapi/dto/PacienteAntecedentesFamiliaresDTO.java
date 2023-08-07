package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteAntecedentesFamiliaresDTO {
    private PacienteDTO paciente;
    private List<AntecedenteFamiliarDTO> antecedentes_familiares;
}
