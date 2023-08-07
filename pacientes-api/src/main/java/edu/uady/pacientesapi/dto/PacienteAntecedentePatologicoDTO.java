package edu.uady.pacientesapi.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteAntecedentePatologicoDTO {
    private PacienteDTO paciente;
    private AntecedentePatologicoDTO antecedente_Patologico;
}
