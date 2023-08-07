package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteAntecedenteFamiliarDTO {

    private PacienteDTO pacienteDTO;
    private AntecedenteFamiliarDTO antecedenteFamiliarDTO;

}
