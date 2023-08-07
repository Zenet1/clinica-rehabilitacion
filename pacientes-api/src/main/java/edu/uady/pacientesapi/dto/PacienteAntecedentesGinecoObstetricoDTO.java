package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteAntecedentesGinecoObstetricoDTO {

    private PacienteDTO paciente;
    private List<AntecedenteGinecoObstetricoDTO> antecedentes_gineco_obstetricos;
}
