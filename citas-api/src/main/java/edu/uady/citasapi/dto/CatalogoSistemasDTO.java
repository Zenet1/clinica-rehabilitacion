package edu.uady.citasapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogoSistemasDTO {

    private CitaDTO pacienteDTO;
    private DiagnosticoDTO antecedenteFamiliarDTO;

}
