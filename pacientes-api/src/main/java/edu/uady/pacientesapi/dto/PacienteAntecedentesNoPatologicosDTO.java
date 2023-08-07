package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PacienteAntecedentesNoPatologicosDTO {

    private PacienteDTO paciente;
    private List<AntecedenteNoPatologicoDTO> antecedente_No_Patologico;
}
