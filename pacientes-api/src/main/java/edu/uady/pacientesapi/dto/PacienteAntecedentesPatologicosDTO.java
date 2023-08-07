package edu.uady.pacientesapi.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteAntecedentesPatologicosDTO {
    private PacienteDTO paciente;
    private List<AntecedentePatologicoDTO> antecedente_Patologico;
}
