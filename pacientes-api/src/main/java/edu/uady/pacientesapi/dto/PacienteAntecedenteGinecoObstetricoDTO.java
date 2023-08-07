package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteAntecedenteGinecoObstetricoDTO {

    private PacienteDTO paciente;
    private AntecedenteGinecoObstetricoDTO antecedente_gineco_obstetrico;
}
