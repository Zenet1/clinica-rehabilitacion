package edu.uady.pacientesapi.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AntecedentePatologicoDTO {

    private String cirugias;
    private String adicciones;
    private String traumatismos;
    private String ETS;
    private String alergias;
    private String padecimientos_articulares;
}
