package edu.uady.pacientesapi.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteAntecedentesPerinatalesDTO {
    private PacienteDTO paciente;
    private List<AntecedentePerinatalDTO> antecedente_Perinatal;
}
