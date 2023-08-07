package edu.uady.pacientesapi.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteAntecedentePerinatalDTO {
    private PacienteDTO paciente;
    private AntecedentePerinatalDTO antecedente_Perinatal;
}
