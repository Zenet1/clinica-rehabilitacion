package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PacienteAntecedenteNoPatologicoDTO {

    private PacienteDTO paciente;
    private AntecedenteNoPatologicoDTO antecedente_No_Patologico;

}
